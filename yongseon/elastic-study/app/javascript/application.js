// Configure your import map in config/importmap.rb. Read more: https://github.com/rails/importmap-rails
//= require jquery3
//= require jquery_ujs
import "@hotwired/turbo-rails"
import "controllers"

$(document).ready(function(){
    $('#search-button').on('click', function () {
        const searchKeyword = $('#search-text').val();

        $.ajax({
            url: `/samsung_mobiles/search?keyword=${searchKeyword}`,
            dataType: 'html',
            success: function(data) {
                $('#mobiles-table').html(data);
            },
            error: function() {
                alert('Error fetching data.');
            }
        });
    })
});