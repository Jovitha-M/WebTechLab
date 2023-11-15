<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
      href="https://fonts.googleapis.com/css?family=Encode Sans"
      rel="stylesheet"
    />
    <title>eventss Catalog</title>
    <style>
        body {
            font-family:'Encode Sans';
            margin: 20px;
            text-align: center;
            background-color: hsla(221, 73%, 63%, 0.82)
        }
        h2 {
            font-size:50px;
            color: #333;
        }
        .container {
            width: 30%; 
            height: 60%; 
            margin: 10px;
            background-color: white;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 50px;
            display: inline-block; 
            vertical-align: top;
        }
        .year {
            font-size: 50px;
            font-weight: bold;
            color: #333;
        }
        .events {
            margin-top: 10px;
            font-size:30px;
        }
    </style>
</head>

<body>
    <?php
    $xmlFile = 'events.xml';

    if (file_exists($xmlFile)) {
        $xml = simplexml_load_file($xmlFile);

        if ($xml) {
            echo "<h2>Event List</h2>";

            foreach ($xml->events as $event) {
                $Year = (string)$event->year;
                $Event1 = (string)$event->event1;
                $Event2 = (string)$event->event2;
                $Event3 = (string)$event->event3;

                echo "<div class='container'>";
                echo "<div class='year'>$Year</div>";
                echo "<div class='events'>";
                echo "<p><strong>1)</strong> $Event1</p>";
                echo "<p><strong>2)</strong> $Event2</p>";
                echo "<p><strong>3)</strong> $Event3</p>";
                echo "</div>";
                echo "</div>";
            }
        } else {
            echo "Error loading XML";
        }
    } else {
        echo "XML file not found";
    }
    ?>
</body>

</html>