$(function(){
	if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
		$(this).css("background-image","url(../frontpages/images/liuyan_14.gif)");
	}
	$(".con_display").toggle(function(){
		if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
			$(this).css("background-image","url(../frontpages/images/shouqi.gif)");
			$(this).parent(".liuyan_every1").siblings(".liuyan_every2").toggle();
		}		
	},function(){
		if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
			$(this).css("background-image","url(../frontpages/images/liuyan_14.gif)");
			$(this).parent(".liuyan_every1").siblings(".liuyan_every2").toggle();
		}
	});
	
	$("#myWords").click(function(){
		$("#wode").css("display","block");
		$("#all").css("display","none");
		$("#woyao").css("display","none");
	});
	
	$("#allWords").click(function(){
		$("#wode").css("display","none");
		$("#all").css("display","block");
		$("#woyao").css("display","none");
	});

});
