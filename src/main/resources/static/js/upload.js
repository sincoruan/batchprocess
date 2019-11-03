$(document).ready(function(){
    $("#uploadbutton").click(display);
});


function display(){
    $.ajax({
        type:"GET",
        url: '/upload/display',
        contentType: 'application/json',
        dataType: 'json',
        success: displayList,
        error: function(){
            console.log("error");
        }
    });
}

function displayList(result){
    let html = "";
    $.each(result,function(index,item){
        html+="<tr>";
        html+="<td>"+item.lastName +"</td>";
        html+="<td>"+item.firstName +"</td>";
        html+="<td>"+item.gpa +"</td>";
        html+="<td>"+item.dob +"</td>";

        html+="</tr>";
    });
    $("#display").html(html);
}

// function uploadfile(evt){
//     evt.preventDefault();
//     let form= $("#uploadform")[0];
//     var data = new FormData(form);
//
//     $.ajax({
//         type: "POST",
//         enctype: 'multipart/form-data',
//         url: "/upload/",
//         data:data,
//         processData: false,
//         contentType: false,
//         cache: false,
//         timeout: 600000,
//         success:function( ){
//             display();
//         },
//         error:function(){
//             console.log("errorr!");
//         }
//     });
// }
