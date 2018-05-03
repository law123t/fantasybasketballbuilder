<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
<script>
    // documentation
    // https://developers.google.com/youtube/iframe_api_reference

    // 2. This code loads the IFrame Player API code asynchronously.
    var tag = document.createElement('script');

    tag.src = "https://www.youtube.com/iframe_api";
    var firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    // 3. This function creates an <iframe> (and YouTube player)
    //    after the API code downloads.
    var player;
    function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
            height: '390',
            width: '640',
            // videoId: 'M7lc1UVf-VE',
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChange
            }
        });
    }

    // 4. The API will call this function when the video player is ready.
    function onPlayerReady(event) {
        // cue a playlist.
        player.cuePlaylist({list: 'PL5j8RirTTnK78PtLzP05VGHAp9qrU8NAE'});
        player.playVideo();
    }

    // 5. The API calls this function when the player's state changes.
    //    The function indicates that when playing a video (state=1),
    //    the player should play for six seconds and then stop.
    var done = false;
    // only load the playlist stuff once.
    var once = true;
    function onPlayerStateChange(event) {

        if (event.data === YT.PlayerState.CUED && once) {
            // load in the new playlist after the first cue event occurs.
            once = false;
            // get the video id's from the playlist.
            var playlist = player.getPlaylist();
            var newPlaylist = [];
            for (var i = 0; i < playlist.length; i++) {
                newPlaylist.push(playlist[i]);
            }
            // create the new playlist with additional video id's.
            newPlaylist.push('M7lc1UVf-VE');
            player.loadPlaylist({playlist: newPlaylist});
        }

        if (event.data == YT.PlayerState.PLAYING && !done) {
            setTimeout(stopVideo, 6000);
            done = true;
        }
    }
    function stopVideo() {
        player.stopVideo();
    }
</script>