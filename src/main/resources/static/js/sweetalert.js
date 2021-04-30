
$('#confirm').on('click', (e) => {

  e.preventDefault()

       Swal.fire({
         title: 'Do you want to save the changes?',
         showCancelButton: true,
         confirmButtonText: `Save`,
       }).then((result) => {
         /* Read more about isConfirmed, isDenied below */
         if (result.isConfirmed) {
           Swal.fire('Saved!', '', 'success')

           setTimeout(function(){ document.actionUser.submit(); }, 1000);
         }
       })
});