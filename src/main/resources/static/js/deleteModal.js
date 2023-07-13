// $('#deleteModal').on('show.bs.modal', function () {
//     $.get("/sdm/delete?firstName=" , function (data) {
//         $('#deleteModal').find('.modal-body').html(data);
//     })
// })

// $('#deleteModal').on('show.bs.modal', function () {
//     $.get("/sdm/delete", function (data) {
//         $('#deleteModal').find('.modal-body').html(data);
//     })
// });

$('.table #deleteBtn').on('click',function(event){
    alert("Js connected");
    event.preventDefault();
    var href = $(this).attr('href');
    $('#deleteModal #delRef').attr('href', href);
    $('#deleteModal').modal();
});