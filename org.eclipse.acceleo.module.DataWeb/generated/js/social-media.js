document.addEventListener('DOMContentLoaded', () => {
    const socialWidgets = document.querySelectorAll('.social-media-widget');
    
    socialWidgets.forEach(widget => {
        const platform = widget.dataset.platform;
        
        switch(platform) {
            case 'twitter':
                loadTwitterWidget(widget);
                break;
            case 'facebook':
                loadFacebookWidget(widget);
                break;
            case 'instagram':
                loadInstagramWidget(widget);
                break;
        }
    });
});

function loadTwitterWidget(widget) {
    if (window.twttr) {
        window.twttr.widgets.load(widget);
    } else {
        const script = document.createElement('script');
        script.src = 'https://platform.twitter.com/widgets.js';
        script.async = true;
        document.body.appendChild(script);
    }
}

function loadFacebookWidget(widget) {
    if (window.FB) {
        window.FB.XFBML.parse(widget);
    } else {
        const script = document.createElement('script');
        script.src = 'https://connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v10.0';
        script.async = true;
        script.defer = true;
        document.body.appendChild(script);
    }
}

function loadInstagramWidget(widget) {
    if (window.instgrm) {
        window.instgrm.Embeds.process(widget);
    } else {
        const script = document.createElement('script');
        script.src = 'https://www.instagram.com/embed.js';
        script.async = true;
        document.body.appendChild(script);
    }
}
