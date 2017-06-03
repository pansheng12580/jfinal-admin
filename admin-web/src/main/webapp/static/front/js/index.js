 //JavaScript Document

$(function(){
	
	//幻灯片第一张效果图
	/*
	showImg(0);
	setTimeout("hideImg(0)",4000);*/
	
	// 鼠标进入幻灯片，左右滑块出现；鼠标离开幻灯片，滑块消失
	
	$(".in_banner").hover(function(){
		$(".slide_right").animate({right:"0px"},200);
		$(".slide_left").animate({left:"0px"},200);
	},function(){
		$(".slide_right").animate({right:"-50px"},200);
		$(".slide_left").animate({left:"-50px"},200);
	});

  
});

//services部分

$(function(){
	 // services部分鼠标进入和鼠标离开事件
	 
	 $("#services_ul li").hover(function(){
		$(".services_icon div",this).stop().animate({"opacity":"1"},300).css({filter:"Alpha(Opacity=100)"});
	},function(){
		$(".services_icon div",this).stop().animate({"opacity":"0"},300).css({filter:"Alpha(Opacity=0)"});
	});
	
	$("#services_con").mousemove(function(e){
		if($(window).width > $(this).width()){
			var leftWidth = ($(window).width() - $(this).width())/2;
		}else{
			var leftWidth = 0;
		}
		var offset = e.clientX - leftWidth;
		$("#services_ul").css("margin-left",-(($("#services_ul").width()-$(this).width())/$(this).width()*offset)+"px");
	});
	
	//关闭 services_pop
	$(".services_popclose").click(function(){
		$(".services_pop").slideUp(200);
		/*$(".services_poptabcon ul li").css("zIndex","1").hide();*/
	});
	
});
// services_tab函数
var popindex = 0;
var slide = false;
function services_tab(popindex,slide){
	$(".services_poptabcon ul li").css("zIndex","1").hide().eq(popindex).css("zIndex","2").show();
	$(".services_poptabbtn a").removeClass("active").eq(popindex).addClass("active");
	if(slide == "true"){
		$(".services_pop").slideDown(200);
	}
}


// project部分

$(function(){
	$(".project_box").hover(function(){
		$(this).children(".project_pop").slideDown(200);
	},function(){
		$(this).children(".project_pop").slideUp(200);
	});
});

var proindex = 0;
function project_tab(proindex){
	$(".project_pic ul li").eq(proindex).show()
	                       .siblings().hide();
	$(".project_btn a").eq(proindex).addClass("active")
	                   .siblings().removeClass("active");
}

// about部分
$(function(){
	$(".about_int a").hover(function(){
		$(this).children("span").stop()
		                        .animate({opacity:"1"},500);
	},function(){
		$(this).children("span").stop()
		                        .animate({opacity:"0"},500);
	});
	
	$(".about_int a").click(function(){
		$(".about_int").stop()
		               .animate({height:"245px"},1000,function(){
						   $(".about_pop").slideDown(300);
						   $(".about_int").animate({height:"1px"},500);
						});
	});	
	$(".about_popclose").click(function(){
		$(".about_pop").slideUp(1000);
		setTimeout(function(){
			$(".about_int").stop().animate({height:"45px"},1000);
		},1200);
	});

});

var abtindex = 0;
function aboutpop_tab(abtindex){
	$(".about_pop_con ul li").slideUp(300).eq(abtindex).slideDown(300);
	$(".about_pop_tab ul li").removeClass("active").eq(abtindex).addClass("active");
	return abtindex;
}

// foot部分

$(function(){
	$(".link_weixin_li a").hover(function(){
		$(".link_weixin_ewm").stop(false,true).animate({height:'138px'},300);
	},function(){
		$(".link_weixin_ewm").stop(false,true).animate({height:'0px'},300);
	});
	
	$(".link_btn ul li a").hover(function(){
		$(this).stop().animate({backgroundPositionY:'-50px'},300);
	},function(){
		$(this).stop().css("background-position-y","0px");
	});
});

$(window).scroll(function(){
	if($("#project").offset().top - $(window).height() + 100 < $(window).scrollTop() && $(window).scrollTop() < $("#project").offset().top -71 ){
		$(".project_title_more").stop().animate({left:'50%'},500);
	}else{
		$(".project_title_more").stop().animate({left:'100%'},500);
	}
	if($("#news").offset().top - $(window).height() -71 < $(window).scrollTop() && $(window).scrollTop() < $("#news").offset().top -71){
		$(".about_btn").stop().animate({left:'50%'},500);
	}else{
		$(".about_btn").stop().animate({left:'-5%'},500);
	}
	
	index1 = $("#services").offset().top;
	index2 = $("#project").offset().top;
	index3 = $("#about").offset().top;
	index4 = $("#news").offset().top;
	index5 = $("#contact").offset().top;
	var scrolltop = $(window).scrollTop() + 71;
	if(index1 > scrolltop){
		indexnum = 0;
	}else if(index1 < scrolltop && index2 > scrolltop){
		indexnum = 1;
	}else if(index2 < scrolltop && index3 > scrolltop){
		indexnum = 2;
	}else if(index3 < scrolltop && index4 > scrolltop){
		indexnum = 3;
	}else if(index4 < scrolltop && index5 > scrolltop){
		indexnum = 4;
	}else if(index5 < scrolltop){
		indexnum = 5;
	}
	$("#nav li").removeClass("active").eq(indexnum).addClass("active");
})
//navMove()
function navMove(id,index){
	if(id == "#index"){
		var headheight = 0;
	}else{
		var headheight = 70;
	}
	var offsettop = $(id).offset().top - headheight;
	$('html,body').stop().animate({scrollTop: offsettop},1500);
	return false;
}

// qq部分

$(function(){
	$(".qqicon").hover(function(){
		$(this).stop().animate({width:"144px"},200);
	},function(){
		$(this).stop().animate({width:"67px"},200);
	});
})

$(function(){
	var qqreg = /^[1-9]{1}[0-9]{4,8}$/;
	$("#messageform").submit(function(){
		if($(".message_name").val() == "请输入您的姓名" || $(".message_name").val() == ""){
			$(".message_about").html("请输入您的姓名");
			return false;
		}else if( $(".message_tel").val() == "请输入您的QQ" || !qqreg.test($(".message_tel").val()) ){
			$(".message_about").html("请输入您的QQ");
			return false;
		}else if($(".message_content").val() == "请输入您的留言" || $(".message_content").val() == ""){
			$(".message_about").html("请输入您的留言");
			return false;
		}else{
			$.ajax({
				url: "index.php?a=form",
				type: "POST",
				data: "title=" + $(".message_name").val() + "&qq=" + $(".message_tel").val() + "&content=" + $(".message_content").val(),
				success: function(data){
					if(data == 1){
						$(".message_about").html("提交成功,我们将在1个工作日内回复。");
						$(".message_name").val('请输入您的姓名');
						$(".message_tel").val('请输入您的QQ');
						$(".message_content").val('请输入您的留言');
					}else{
						$(".message_about").html("提交失败,请直接联系QQ客服。");
					}
				}
			})
		}
		return false;
	})
})

