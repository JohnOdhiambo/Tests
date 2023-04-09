<?php

require('db.php');

$response = array();
    if ($con) {
        $sql = "Select id,name,age,email from users";
        $result = mysqli_query($con, $sql);
        if ($result) {
            header("Content-Type: JSON");
            //$i = 0;
            while($row = mysqli_fetch_assoc($result)){
                $response = $row['id'];
                $response = $row['name'];
                $response = $row['age'];
                $response = $row['email'];

                //$i++;

            }
            echo json_encode($response, JSON_PRETTY_PRINT);
        }

    } 

?>