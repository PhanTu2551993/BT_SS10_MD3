<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/7/2024
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form>
    <input type="text">
    <button type="submit">Login</button>
</form>
<table>
    <thead>
    <tr>
        <th>Stt</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    // let form = document.getElementsByTagName("form")[0];
    // form.addEventListener("submit",function (e) {
    //     e.preventDefault();
    //     location.href = "index.html"
    // })
    let arr = [
        {id:1,name:"hung",age:21},
        {id:2,name:"nam",age:21},
        {id:3,name:"khanh",age:21},
        {id:4,name:"duc",age:21},
        {id:5,name:"hau",age:21}
    ]
    let html = arr.reduce((total,element,index)=>total+` <tr>
                <td>${index+1}</td>
                <td>${element.name}</td>
                <td>${element.age}</td>
            </tr>`,"")

    let intArr =  [1,2,3,4,5,6,7,8,9]
    let total =  intArr.reduce((sum, element) =>sum+element,0)
    console.log(total);

    let  arrCopy =intArr.map((element, i) =>{
        //  tinsh gia thua
        let multi = 1;
        for(let i = 1; i <= element;i++){
            multi*= i
        }
        return 1;
    })
    console.log(arrCopy);
    // arr.forEach((element,index)=>{
    // html+= ` <tr>
    //     <td>${index+1}</td>
    //     <td>${element.name}</td>
    //     <td>${element.age}</td>
    // </tr>`
    // })
    $("body").html(html)
    $(document).ready(function(){
        $("form").submit(function(e){
            e.preventDefault();
            location.href = "index.jsp"
        })
    })
</script>
</body>
</html>
