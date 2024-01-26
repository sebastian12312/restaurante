/**
 ELIMINAR ITEM
 */


var eliminarItem = document.querySelectorAll(".eliminar-item");

for (let item of eliminarItem) {
    item.addEventListener("click", (e) => {
        var id_empleado = item.getAttribute("data-id");

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: "btn-aceptar",
                cancelButton: "btn-eliminar"
            },
            buttonsStyling: false
        });

        swalWithBootstrapButtons.fire({
            title: "¿Estás seguro?",
            text: "No podrás revertir esto.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonText: "Sí, eliminar!",
            cancelButtonText: "No, cancelar!",
        }).then((result) => {
            if (result.isConfirmed) {
                // Realizar la solicitud Fetch para eliminar el usuario


                   // Cambiar dinámicamente el href
                   item.setAttribute("href", "/administrador/empleados/delete/" + id_empleado + "");
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`Error: ${response.statusText}`);

                        }

                        return response.text();
                    })
                    .then(data => {
                        swalWithBootstrapButtons.fire({
                            title: "Eliminado!",
                            text: "El usuario ha sido eliminado.",
                            icon: "success"
                        });
                        // Puedes recargar la página o actualizar la lista de usuarios aquí si es necesario
                         setTimeout(function(){
                         location.reload();
                         },3000)
                    })
                    .catch(error => {
                        console.error(error);
                        swalWithBootstrapButtons.fire({
                            title: "Error",
                            text: "Error al eliminar el usuario.",
                            icon: "error"
                        });
                    });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire({
                    title: "Cancelado",
                    text: "El usuario está a salvo :)",
                    icon: "error"
                });
            }
        });
    });
}

 var eliminarItem = document.querySelectorAll(".eliminar-item");

 eliminarItem.forEach(function(item) {
     // Obtener el valor del atributo data-id


     // Agregar un evento de clic
     item.addEventListener("click", function(e) {
         e.preventDefault(); // Prevenir el comportamiento predeterminado del enlace si es necesario

         // SweetAlert para la confirmación
         const swalWithBootstrapButtons = Swal.mixin({
             customClass: {
                 confirmButton: "btn-aceptar",
                 cancelButton: "btn-eliminar"
             },
             buttonsStyling: false
         });

         swalWithBootstrapButtons.fire({
             title: "¿Estás seguro?",
             text: "No podrás revertir esto.",
             icon: "warning",
             showCancelButton: true,
             confirmButtonText: "Sí, eliminar",
             cancelButtonText: "No, cancelar"
         }).then((result) => {
             if (result.isConfirmed) {
                 // Realizar la eliminación
                 swalWithBootstrapButtons.fire({
                     title: "Eliminado",
                     text: "El archivo ha sido eliminado.",
                     icon: "success"
                 });
             } else if (result.dismiss === Swal.DismissReason.cancel) {
                 swalWithBootstrapButtons.fire({
                     title: "Cancelado",
                     text: "El archivo imaginario está a salvo :)",
                     icon: "error"
                 });
             }
         });
     });
 });



 var AgregarItem = document.querySelectorAll(".agregar-item");
for(Agregar of AgregarItem){
    Agregar.addEventListener("click", (e)=>{
        const Toast = Swal.mixin({
            toast: true,
            position: "top-end",
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.onmouseenter = Swal.stopTimer;
              toast.onmouseleave = Swal.resumeTimer;
            }
          });
          Toast.fire({
            icon: "success",
            title: "Registro Completado!"
          });
    }) 
}