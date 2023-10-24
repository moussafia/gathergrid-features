$(document).on("click", ".delete-event-btn",function (){
    let clickedBtn = $(this)
    $(".idEventDelete").val(clickedBtn.attr("data-eventId"))
    console.log($(".idEventDelete"))
})
