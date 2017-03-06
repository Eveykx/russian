
$(document).ready(function() {
        $("ul.nav li").hover(function(){
            $(this).addClass("on")
        },
        function(){
            $(this).removeClass("on");

        });
    });

$(document).ready(function() {
        $("ul.nav li").hover(function(){
            $(this).parent("ul").siblings("a").addClass("choice");

        },
        function(){
            $(this).parent("ul").siblings("a").removeClass("choice");
        })
});
