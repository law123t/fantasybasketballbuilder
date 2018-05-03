<head>
    <title> ${pageTitle}</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    <style>
        .droppable { border:1px dashed #000000; width:50%; float:left; height:60px; margin: 10px;}

        /* Style for Point Guard Draggable */
        #tmpl-view-legend-container {
            right:20px;
            top:0px;
            height:200px;
            overflow-y:scroll;
        }

        #tmpl-view-legend-container ul { list-style-type:none; padding:0; }
        #tmpl-view-legend-container ul li { background:#CCCCCC; margin-bottom:1px; width:500px; padding:7px 10px; cursor:pointer; }

        li.ui-draggable.ui-draggable-handle.ui-draggable-dragging { list-style-type:none; background:#CCCCCC; margin-bottom:10px; padding:7px 10px; cursor:pointer; }

        /* Style for Shooting Guard Draggable */
        #tmpl-view-legend-container2 {
            right:20px;
            top:0px;
            height:200px;
            overflow-y:scroll;
        }

        #tmpl-view-legend-container2 ul { list-style-type:none; padding:0; }
        #tmpl-view-legend-container2 ul li { background:#CCCCCC; margin-bottom:1px;width:500px; padding:7px 10px; cursor:pointer; }

        li.ui-draggable.ui-draggable-handle.ui-draggable-dragging { list-style-type:none; background:#CCCCCC; margin-bottom:10px; padding:7px 10px; cursor:pointer; }

        /* Style for Small Forward Draggable */
        #tmpl-view-legend-container3 {
            right:20px;
            top:0px;
            height:200px;
            overflow-y:scroll;
        }

        #tmpl-view-legend-container3 ul { list-style-type:none; padding:0; }
        #tmpl-view-legend-container3 ul li { background:#CCCCCC; margin-bottom:1px;width:500px; padding:7px 10px; cursor:pointer; }

        li.ui-draggable.ui-draggable-handle.ui-draggable-dragging { list-style-type:none; background:#CCCCCC; margin-bottom:10px; padding:7px 10px; cursor:pointer; }

        /* Style for Power Forward Draggable */
        #tmpl-view-legend-container4 {
            right:20px;
            top:0px;
            height:200px;
            overflow-y:scroll;
        }

        #tmpl-view-legend-container4 ul { list-style-type:none; padding:0; }
        #tmpl-view-legend-container4 ul li { background:#CCCCCC; margin-bottom:1px;width:500px; padding:7px 10px; cursor:pointer; }

        li.ui-draggable.ui-draggable-handle.ui-draggable-dragging { list-style-type:none; background:#CCCCCC; margin-bottom:10px; padding:7px 10px; cursor:pointer; }

        /* Style for Center Draggable */
        #tmpl-view-legend-container5 {
            right:20px;
            top:0px;
            height:200px;
            overflow-y:scroll;
        }

        #tmpl-view-legend-container5 ul { list-style-type:none; padding:0; }
        #tmpl-view-legend-container5 ul li { background:#CCCCCC; margin-bottom:1px;width:500px; padding:7px 10px; cursor:pointer; }

        li.ui-draggable.ui-draggable-handle.ui-draggable-dragging { list-style-type:none; background:#CCCCCC; margin-bottom:10px; padding:7px 10px; cursor:pointer; }

        #yourteam {
            padding:10px;
            margin-top: 10px;
            margin-right: auto;
            margin-left: auto;
            background-color: #FFFFFF;
            border: 5px solid black;
            width: 95%;
        }

        .hero-section {
            margin-bottom: 15px;
            background: url("basketballApp/content-jsp/img/kobepic.jpg") 50% no-repeat;
            background-size: cover;
            width: 100%;
            height: 60vh;
            text-align: center;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-align-items: center;
            -ms-flex-align: center;
            align-items: center;
            -webkit-justify-content: center;
            -ms-flex-pack: center;
            justify-content: center;
        }

        .hero-section .hero-section-text {
            position: relative;
            top: 100px;
            right: 70px;
            color: #fefefe;
            font-size: 1.35em;
            text-shadow: 1px 1px 2px #0a0a0a;
        }
        body {
            background-color: #7F7373;
        }

        #submitteam {
            font-size:1.5em;
            padding:20px;
            margin: 10px 70px 10px 10px;
        }
        #successtext {
            color: palevioletred;
        }
    </style>
</head>