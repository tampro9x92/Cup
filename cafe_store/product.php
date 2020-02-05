<?php
    include 'connection.php';
    $name = $_POST['name'];
    $price = $_POST['price'];
    $status = $_POST['status'];
    $id_category = $_POST['id_category'];
    if($name!=null&&$price!=null&&$status!=null&&$id_category!=null){
        $sql = "INSERT INTO `product` ( `name`, `price`, `status`, `id_category`) VALUES ('$name','$price','$status','$id_category')";
        $query = $conn->query($sql); 
        if($query){
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="insert success";
            $appDataGetBack['code']="200";
            $appDataGetBack['data']=null;
        }else{
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="insert fail";
            $appDataGetBack['code']="400";
            $appDataGetBack['data']=null;
        }
    }else{
        $sql = "SELECT*FROM `product`";
        $query = $conn->query($sql);
        $arr =  array();
        if($query){
            while($row = $query->fetch_array()){
                $arr[] = array(
                    'id'=>$row['id'],
                    'name'=>$row['name'],
                    'price'=>$row['price'],
                    'status'=>$row['status']  
                );
            }
            $appDataGetBack['total']=sizeof($arr);
            $appDataGetBack['message']="get menu success";
            $appDataGetBack['code']="200";
            $appDataGetBack['data']=$arr;
        }else{
            $appDataGetBack['total']=sizeof($arr);
            $appDataGetBack['message']="get menu fail";
            $appDataGetBack['code']="401";
            $appDataGetBack['data']= null;
        }
    }
?>