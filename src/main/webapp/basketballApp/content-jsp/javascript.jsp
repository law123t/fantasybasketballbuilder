<!-- Bootstrap core JavaScript -->
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
<script>
    if( !$('#deleteteam').val() ) {
        document.getElementById('submitteamdelete').disabled = true;
    }
</script>

<script>
    if( !$('#team').val() ) {
        document.getElementById('teamselect').disabled = true;
    }
</script>
