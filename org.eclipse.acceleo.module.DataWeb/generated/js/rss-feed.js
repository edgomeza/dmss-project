document.addEventListener('DOMContentLoaded', () => {
    const rssFeedContainers = document.querySelectorAll('.rss-feed-container');
    
    rssFeedContainers.forEach(container => {
        const feedUrl = container.dataset.feedUrl;
        const maxItems = parseInt(container.dataset.maxItems, 10) || 5;
        
        fetchRSSFeed(feedUrl, maxItems)
            .then(items => renderRSSFeed(container, items))
            .catch(error => {
                console.error('Error cargando feed RSS:', error);
                container.innerHTML = '<p>No se pudo cargar el feed RSS</p>';
            });
    });
});

async function fetchRSSFeed(url, maxItems) {
    // Usando un servicio de conversión RSS a JSON para evitar problemas de CORS
    const apiUrl = `https://api.allorigins.win/get?url=${encodeURIComponent(url)}`;
    
    const response = await fetch(apiUrl);
    const data = await response.json();
    
    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(data.contents, 'text/xml');
    
    const items = Array.from(xmlDoc.querySelectorAll('item'))
        .slice(0, maxItems)
        .map(item => ({
            title: item.querySelector('title')?.textContent || '',
            link: item.querySelector('link')?.textContent || '',
            description: item.querySelector('description')?.textContent || '',
            pubDate: item.querySelector('pubDate')?.textContent || ''
        }));
    
    return items;
}

function renderRSSFeed(container, items) {
    const feedHTML = items.map(item => `
        <div class="rss-feed-item">
            <h3><a href="${item.link}" target="_blank">${item.title}</a></h3>
            <p>${item.description}</p>
            <small>${item.pubDate}</small>
        </div>
    `).join('');
    
    container.innerHTML = `
        <div class="rss-feed-list">
            ${feedHTML}
        </div>
    `;
}
