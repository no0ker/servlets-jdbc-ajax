function send_data()
{
    $('#resultTable').empty();

    var message = {};
    message.firstName = $("#fn").val();
    message.middleName = $("#mn").val();
    message.secondName = $("#sn").val();
    message.city = $("#city").val();
    message.color = $("#color").val();
    message.model = $("#model").val();

    $.ajax({
        url: "/servlets-jdbc-ajax/api/getUsers",
        method : "POST",
        data: message,
        success: function(result) {
            createTable(result);
        }
    });
}

function createTable(result){
    var rows = result.rows;
    var header = '<tr><td>first name</td><td>middle name</td><td>second name</td><td>city</td><td>car\'s color</td><td>car\'s model</td></tr>';

    var resultHtml = '<table border = "1" cellspacing="0" cellpadding="5">';
    resultHtml += header;
    for(var i = 0; i < rows.length; ++i){
        resultHtml += '<tr>';
        resultHtml += '<td>';
        resultHtml += rows[i].firstName;
        resultHtml += '</td>';

        resultHtml += '<td>';
        resultHtml += rows[i].middleName;
        resultHtml += '</td>';

        resultHtml += '<td>';
        resultHtml += rows[i].secondName;
        resultHtml += '</td>';

        resultHtml += '<td>';
        resultHtml += rows[i].city;
        resultHtml += '</td>';

        resultHtml += '<td>';
        resultHtml += rows[i].carColor;
        resultHtml += '</td>';

        resultHtml += '<td>';
        resultHtml += rows[i].model;
        resultHtml += '</td>';
        resultHtml += '</tr>'
    }
    resultHtml += '</table>';

    $('#resultTable').append(resultHtml);
}