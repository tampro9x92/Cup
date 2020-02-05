<?php
    include 'connection.php';
    $id_user = $_POST['id_user'];
    $login_regular = $_POST['login_regular'];
    $id_product = $_POST['id_prodcut'];
    $number = $_POST['number'];
    if($id_product!=null&&$number!=null){
        $sql = "INSERT INTO `cart`(`id_user`, `id_product`, `number`) VALUES ('$id_user','$id_product','$number')";
        $query = $conn->query($sql);
        if($query){
            $appDataGetBack['total']="0";
            $appDataGetBack['message'] = "add to cart success";
            $appDataGetBack['code']="200";
            $appDataGetBack['data']=null;
        }else{
            $appDataGetBack['total']="0";
            $appDataGetBack['message'] = "add to cart fail";
            $appDataGetBack['code']="401";
            $appDataGetBack['data']=null;
        }   
    }else{
        if($login_type){
            $sql = "SELECT `name`,`price`,`number` FROM `cart` INNER JOIN `product` ON `cart.id_user` = `product.id`";
            $query = $conn->query($sql);
            while($row = $query->fetch_array()){
                $arr = array(
                    'name'=>$row['name'],
                    'price'=>$row['price'],
                    'number'=>$row['number']
                );
            }
            if($query){
                $appDataGetBack['total']="0";
                $appDataGetBack['message'] = "get cart success";
                $appDataGetBack['code']="200";
                $appDataGetBack['data']=$arr;
            }else{
                $appDataGetBack['total']="0";
                $appDataGetBack['message'] = "get cart fail";
                $appDataGetBack['code']="401";
                $appDataGetBack['data']=null;
            }
        }else{
            $sql = "SELECT `name`,`price`,`number` FROM `cart` INNER JOIN `product` ON `cart.id_other_user` = `product.id`";
            $query = $conn->query($sql);
            while($row = $query->fetch_array()){
                $arr = array(
                    'name'=>$row['name'],
                    'price'=>$row['price'],
                    'number'=>$row['number']
                );
            }
            if($query){
                $appDataGetBack['total']="0";
                $appDataGetBack['message'] = "get cart success";
                $appDataGetBack['code']="200";
                $appDataGetBack['data']=$arr;
            }else{
                $appDataGetBack['total']="0";
                $appDataGetBack['message'] = "get cart fail";
                $appDataGetBack['code']="401";
                $appDataGetBack['data']=null;
            }
        }
    }
    echo json_encode($appDataGetBack);
?>
