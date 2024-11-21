$(document).ready(function() {
    function showAlert(message, type) {
        const alertHtml = `
            <div class="alert alert-${type} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        `;
        $('#alertContainer').html(alertHtml);
        
        setTimeout(function() {
            $('.alert').alert('close');
        }, 3000);
    }

   

    $('#studentForm').on('submit', function(event) {
        event.preventDefault();
        const id = $('#id').val();
        console.log('eeeeeeeeeee',id)
        // Check ID again before submitting
        $.ajax({
            url: '/students/check/' + id,
            type: 'GET',
            success: function(exists) {
                if(exists) {
                    showAlert('This ID already exists!', 'danger');
                    return;
                }
                
                const studentData = {
                    id: id,
                    name: $('#name').val(),
                    genre: $('#genre').val()
                };
                
                $.ajax({
                    url: '/students',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(studentData),
                    success: function(response) {
                        showAlert('Student added successfully!', 'success');
                        setTimeout(() => {
                            location.reload();
                        }, 1500);
                    },
                    error: function() {
                        showAlert('Error adding student!', 'danger');
                    }
                });
            }
        });
    });

    $(document).on('click', '.delete-btn', function() {
        const studentId = $(this).attr('data-id');
        $.ajax({
            url: '/students/' + studentId,
            type: 'DELETE',
            success: function(response) {
                showAlert('Student deleted successfully!', 'success');
                // Delay reload to show the alert
                setTimeout(() => {
                    location.reload();
                }, 1500);
            },
            error: function() {
                showAlert('Error deleting student!', 'danger');
            }
        });
    });

    $(document).on('click', '.edit-btn', function() {
        const studentId = $(this).attr('data-id');
        const name = $(this).attr('data-name');
        const genre = $(this).attr('data-genre');
        $('#edit-id').val(studentId);
        $('#edit-name').val(name);
        $('#edit-genre').val(genre);
        $('#editStudentModal').modal('show');
    });
});