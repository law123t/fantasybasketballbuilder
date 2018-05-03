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
    var pgID = 0;
    var sgID = 0;
    var sfID = 0;
    var pfID = 0;
    var cID = 0;
    var pgName="";
    var sgName = "";
    var sfName = "";
    var pfName = "";
    var cName = "";
    var teamName = "";

    $(function() {
        $('#pgdata').droppable({
            accept:'#tmpl-view-legend-item-container li',
            hoverClass: 'hovered',
            drop: testDropFunctionpg,

        });

        $('#tmpl-view-legend-item-container li').draggable({
            stack: '#tmpl-view-legend-items li',
            cursor: 'move',
            revert: true,
            appendTo: 'body',
            helper: 'clone',
            start: function(e, ui) {
                ui.helper.width($(this).width());
                $(this).css('visibility', 'hidden');
            },
            stop: function(e, ui) {
                $(this).css('visibility', '');
            }
        });
    });

    $(function() {
        $('#sgdata').droppable({
            accept:'#tmpl-view-legend-item-container2 li',
            hoverClass: 'hovered',
            drop: testDropFunctionsg
        });

        $('#tmpl-view-legend-item-container2 li').draggable({
            stack: '#tmpl-view-legend-items2 li',
            cursor: 'move',
            revert: true,
            appendTo: 'body',
            helper: 'clone',
            start: function(e, ui) {
                ui.helper.width($(this).width());
                $(this).css('visibility', 'hidden');
            },
            stop: function(e, ui) {
                $(this).css('visibility', '');
            }
        });
    });

    $(function() {
        $('#sfdata').droppable({
            accept:'#tmpl-view-legend-item-container3 li',
            hoverClass: 'hovered',
            drop: testDropFunctionsf
        });

        $('#tmpl-view-legend-item-container3 li').draggable({
            stack: '#tmpl-view-legend-items3 li',
            cursor: 'move',
            revert: true,
            appendTo: 'body',
            helper: 'clone',
            start: function(e, ui) {
                ui.helper.width($(this).width());
                $(this).css('visibility', 'hidden');
            },
            stop: function(e, ui) {
                $(this).css('visibility', '');
            }
        });
    });

    $(function() {
        $('#pfdata').droppable({
            accept:'#tmpl-view-legend-item-container4 li',
            hoverClass: 'hovered',
            drop: testDropFunctionpf
        });

        $('#tmpl-view-legend-item-container4 li').draggable({
            stack: '#tmpl-view-legend-items4 li',
            cursor: 'move',
            revert: true,
            appendTo: 'body',
            helper: 'clone',
            start: function(e, ui) {
                ui.helper.width($(this).width());
                $(this).css('visibility', 'hidden');
            },
            stop: function(e, ui) {
                $(this).css('visibility', '');
            }
        });
    });

    $(function() {
        $('#cdata').droppable({
            accept:'#tmpl-view-legend-item-container5 li',
            hoverClass: 'hovered',
            drop: testDropFunctionc
        });

        $('#tmpl-view-legend-item-container5 li').draggable({
            stack: '#tmpl-view-legend-items5 li',
            cursor: 'move',
            revert: true,
            appendTo: 'body',
            helper: 'clone',
            start: function(e, ui) {
                ui.helper.width($(this).width());
                $(this).css('visibility', 'hidden');
            },
            stop: function(e, ui) {
                $(this).css('visibility', '');
            }
        });
    });

    function testDropFunctionpg(event, ui) {
        pgID = ui.draggable.attr('id');
        pgName = ui.draggable.attr('value');

        var outputText = pgName;

        if(isEmpty($('#currentPG'))) {
            var pgtext = document.getElementById("currentPG");
            var text = document.createTextNode(outputText);
            pgtext.appendChild(text);
        } else {
            var pgtext = document.getElementById("currentPG");
            $('#currentPG').empty();
            var text = document.createTextNode(outputText);
            pgtext.appendChild(text);
        }
        var pgutext = document.getElementById("pgUpdater");
        $('#pgUpdater').empty();
        var text = document.createTextNode("Chosen Point Guard: " + outputText);
        pgutext.appendChild(text);
    }

    function testDropFunctionsg(event, ui) {
        sgID = ui.draggable.attr('id');
        sgName = ui.draggable.attr('value');

        var outputText = sgName;

        if(isEmpty($('#currentSG'))) {
            var sgtext = document.getElementById("currentSG");
            var text = document.createTextNode(outputText);
            sgtext.appendChild(text);
        } else {
            var sgtext = document.getElementById("currentSG");
            $('#currentSG').empty();
            var text = document.createTextNode(outputText);
            sgtext.appendChild(text);
        }

        var sgutext = document.getElementById("sgUpdater");
        $('#sgUpdater').empty();
        var text = document.createTextNode("Chosen Shooting Guard: " + outputText);
        sgutext.appendChild(text);
    }

    function testDropFunctionsf(event, ui) {
        sfID = ui.draggable.attr('id');
        sfName = ui.draggable.attr('value');

        var outputText = sfName;

        if(isEmpty($('#currentSF'))) {
            var sftext = document.getElementById("currentSF");
            var text = document.createTextNode(outputText);
            sftext.appendChild(text);
        } else {
            var sftext = document.getElementById("currentSF");
            $('#currentSF').empty();
            var text = document.createTextNode(outputText);
            sftext.appendChild(text);
        }

        var sfutext = document.getElementById("sfUpdater");
        $('#sfUpdater').empty();
        var text = document.createTextNode("Chosen Small Forward: " + outputText);
        sfutext.appendChild(text);
    }

    function testDropFunctionpf(event, ui) {
        pfID = ui.draggable.attr('id');
        pfName = ui.draggable.attr('value');

        var outputText = pfName;

        if(isEmpty($('#currentPF'))) {
            var pftext = document.getElementById("currentPF");
            var text = document.createTextNode(outputText);
            pftext.appendChild(text);
        } else {
            var pftext = document.getElementById("currentPF");
            $('#currentPF').empty();
            var text = document.createTextNode(outputText);
            pftext.appendChild(text);
        }
        var pfutext = document.getElementById("pfUpdater");
        $('#pfUpdater').empty();
        var text = document.createTextNode("Chosen Power Forward: " + outputText);
        pfutext.appendChild(text);
    }

    function testDropFunctionc(event, ui) {
        cID = ui.draggable.attr('id');
        cName = ui.draggable.attr('value');
        var outputText = cName;

        if(isEmpty($('#currentC'))) {
            var ctext = document.getElementById("currentC");
            var text = document.createTextNode(outputText);
            ctext.appendChild(text);
        } else {
            var ctext = document.getElementById("currentC");
            $('#currentC').empty();
            var text = document.createTextNode(outputText);
            ctext.appendChild(text);
        }
        var cutext = document.getElementById("cUpdater");
        $('#cUpdater').empty();
        var text = document.createTextNode("Chosen Center: " + outputText);
        cutext.appendChild(text);
    }

    function isEmpty( el ){
        return !$.trim(el.html())
    }

    $(document).ready(function() {
        $("#submitteam").click(function() {
            $('#successtext').empty();
            var teamName = $('input[name="teamName"]').val();
            if (pgID > 0 && sgID > 0 && sfID > 0 && pfID > 0 && cID > 0 && teamName !== ""){
                servletCall();
            } else if (pgID === 0 || sgID === 0 || sfID === 0 || pfID === 0 || cID === 0 && teamName === ""){
                var outputText = "Please Choose all positions and enter a name!"
                var suctext = document.getElementById("successtext");
                $('#successtext').empty();
                var text = document.createTextNode(outputText);
                suctext.appendChild(text);
                $('html, body').animate({
                    scrollTop: $("#successtext").offset().top
                }, 2000);
            } else if (pgID === 0 || sgID === 0 || sfID === 0 || pfID === 0 || cID === 0){
                var outputText = "Please Choose all positions!"
                var suctext = document.getElementById("successtext");
                $('#successtext').empty();
                var text = document.createTextNode(outputText);
                suctext.appendChild(text);
                $('html, body').animate({
                    scrollTop: $("#successtext").offset().top
                }, 2000);
            } else if (teamName === ""){
                var outputText = "Please Enter a name!"
                var suctext = document.getElementById("successtext");
                $('#successtext').empty();
                var text = document.createTextNode(outputText);
                suctext.appendChild(text);
                $('html, body').animate({
                    scrollTop: $("#successtext").offset().top
                }, 2000);
            } else {
                location.reload();
                alert("something went wrong! reloading form");
            }
        });
    });
    function servletCall() {
        var teamName = $('input[name="teamName"]').val();
        $.post(
            "createTeam",
            {teamName: teamName, pointGuard: pgID, shootingGuard: sgID, smallForward: sfID, powerForward: pfID, center: cID}, //meaasge you want to send
            function() {
                pgID = 0;
                sgID = 0;
                sfID = 0;
                pfID = 0;
                var cID = 0;
                pgName="";
                sgName = "";
                sfName = "";
                pfName = "";
                cName = "";
                $('#currentPG').empty();
                $('#currentSG').empty();
                $('#currentSF').empty();
                $('#currentPF').empty();
                $('#currentC').empty();
                var outputText = "Your Team: " + teamName + " was added!";
                var suctext = document.getElementById("successtext");
                var text = document.createTextNode(outputText);
                suctext.appendChild(text);
                $('html, body').animate({
                    scrollTop: $("#successtext").offset().top
                }, 2000);
            }
        )
    }
</script>