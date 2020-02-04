<?php
    include 'connection.php';
    $id_user = $_POST['id_user'];
    $name = $_POST['name'];
    $price = $_POST['price'];
    $status = $_POST['status'];
    $table = $_POST['table'];
    $decription = $_POST['decription'];
    $date = $_POST['date'];
    $is_pay = $_POST['is_pay'];
    if($name!=null&&$price!=null&&$status!=null&&$table!=null){
        $sql = "INSERT INTO `order` (`id_user`, `name`, `price`, `status`, `table`, `description`, `date`, `is_pay`) VALUES ('$id_user','$name','$price','$status','$table','$decription','$date',$is_pay)";
        $query = $conn->query($sql);
        if($query){
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="order success";
            $appDataGetBack["code"]="200";
            $appDataGetBack['data']=null;
        }else{
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="order fail";
            $appDataGetBack["code"]="401";
            $appDataGetBack['data']=null;
        }
    }else{
        $sql = "SELECT * FROM `order` WHERE `id_user`= '$id_user'";
        $query = $conn->query($sql);
        $arr =  array();
        if($query){
            while($row = $query->fetch_array()){
                $arr[] = array(
                   'id'->$row['id'],
                   'name'->$row['name'],
                    'price'->$row['price'],
                    'status'->$row['status'],
                    'table' -> $row['table'],
                    'description'->$row['description'],
                    'date'->$row['date'],
                   'is_pay'->$row['is_pay']
                );
            }
            $appDataGetBack['total'] = sizeof($arr);
            $appDataGetBack['message'] = "get order success";
            $appDataGetBack['code'] = "200";
            $appDataGetBack['data'] = $arr;
        }else{
            $appDataGetBack['total'] = sizeof($arr);
            $appDataGetBack['message'] = "get order success";
            $appDataGetBack['code'] = "200";
            $appDataGetBack['data'] = null;
        }
    }
?>