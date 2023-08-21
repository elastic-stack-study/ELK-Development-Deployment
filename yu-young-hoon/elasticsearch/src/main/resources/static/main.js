$(window).on("load", function () {
    search("/random")
    $("#button").click(function () {
        const text = $("#input").val()
        search(`/search/${text}`)
    });
});

function search(url) {
    $("#items").text("");
    fetch(url)
        .then((response) => response.json())
        .then((response) => {
            response.forEach(d => {
                console.log(JSON.stringify(d))
                $("#items").append(`
                    <div class="col-lg-4">
                        <div class="col-md-12">
                            <img src="${d.thumbnail}"/>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-12 title">${d.title}</div>
                        </div>
                    </div>
                `)
            });
        });
}