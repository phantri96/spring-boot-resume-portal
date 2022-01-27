const skills = document.getElementById('skills');
const token = $('#_csrf').attr('content');
const header = $('#_csrf_header').attr('content');

$(document).ready(function(){

  console.log('document loaded');

});

var addSkillBody = {
    type: 'skill',
    action: 'add'
};

$(document).ready(function(){
    $("#add-skill").click(function() {
        $.ajax({
            url : '/profile/edit',
            type: 'post',
            data: addSkillBody,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        })
    });
    $(".delete-btn").click(function() {
        var index = $(this).attr('id');
        var type = $(this).attr('d-type');
        $.ajax ( {
            type: 'delete',
            url : '/profile/edit/' + type + '/' + index,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success:  function(result ) {
                window.location = '/profile/edit';
            }
        });

    });

    $("#add-education-btn").click(function() {
        $.ajax({
            url : '/profile/edit',
            type: 'post',
            data: {
                type: 'education',
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        })
    });
    $("#add-experience-btn").click(function() {
        $.ajax({
            url : '/profile/edit',
            type: 'post',
            data: {
                type: 'experience'
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        })
    });
});