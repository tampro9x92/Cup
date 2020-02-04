<?php
    include 'connection.php';
    include 'uploadImage.php';
    $id = $_POST['id'];
    $sql = "INSERT INTO `image` ( `image`, `id_user`, `id_product`) VALUES ('$file_path','$id',2)";
    if($checkUploadFile){
        $query = $conn->query($sql);
    }
    echo json_encode($appDataGetBack);
?>