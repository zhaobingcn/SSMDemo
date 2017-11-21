/**
 * Created by zhzy on 2017/11/21.
 */
var detailList = $("#detail-list").empty();

function showDetail() {
    var json = getQueryData();
    $("<h3>" + "Age:" + json.age + "</h3>").appendTo(detailList);
}

function getQueryData() {
    var name = $("#user-name").val();
    var details;
    $.ajax({
        url : "/detail",
        data : {
            "name": name},
        dataType: "json",
        async: false,
            success: function (data) {
                details = data;
            }
        });
    return details;
}