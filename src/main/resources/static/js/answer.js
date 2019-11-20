$(function(){
	
	// 默认获取第一题
	getTopicByPaperIdAndTopicId(getUrlParam('id'), 1);
	
	
	// 答案选择事件
	$(document).on('click', 'input[name=answer]', function(){
		var number = $(this).val();
		var topicNumber = $(this).attr('data-number');
		// 记录答案
		$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').attr('data-answer', number);
		
		// 颜色标记
		if (typeof(number) != "undefined"){
			// 已选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('not-answered');
		} else {
			// 未选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('not-answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('answered');
		}
		
		// 保存答案
		saveAnswer();
	});
	
	// 上一题按钮
	$(document).on('click ', 'button.previous', function(){
		if ($(this).is('.disable')){
			return;
		}
		
		// 保存答案
		var number = $('input[name=answer]:checked').val();
		var topicNumber = $('input[name=answer]').attr('data-number');
		$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').attr('data-answer', number);
		
		// 颜色标记
		if (typeof(number) != "undefined"){
			// 已选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('not-answered');
		} else {
			// 未选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('not-answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('answered');
		}
		
		var page = $(this).attr('data-page');
		getTopicByPaperIdAndTopicId(getUrlParam('id'), page);
	});
	// 下一题按钮
	$(document).on('click', 'button.next', function(){
		if ($(this).is('.disable')){
			return;
		}
		
		// 保存答案
		var number = $('input[name=answer]:checked').val();
		var topicNumber = $('input[name=answer]').attr('data-number');
		$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').attr('data-answer', number);
		
		// 颜色标记
		if (typeof(number) != "undefined"){
			// 已选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('not-answered');
		} else {
			// 未选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('not-answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('answered');
		}
		
		var page = $(this).attr('data-page');
		getTopicByPaperIdAndTopicId(getUrlParam('id'), page);
	});
	
	
	
	// 答题卡点击事件
	$(document).on('click', 'div.answer-sheet-area>ul>li', function(){
		
		// 保存答案
		var number = $('input[name=answer]:checked').val();
		var topicNumber = $('input[name=answer]').attr('data-number');
		$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').attr('data-answer', number);
		
		// 颜色标记
		if (typeof(number) != "undefined"){
			// 已选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('not-answered');
		} else {
			// 未选择答案
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').addClass('not-answered');
			$('div.answer-sheet-area>ul>li[data-number=' + topicNumber + ']').removeClass('answered');
		}
		
		var page = $(this).attr('data-number');
		getTopicByPaperIdAndTopicId(getUrlParam('id'), page);
	});
	
	
	// 交卷按钮点击事件
	$(document).on('click', 'button.submit', function(){
		var answers = '';
		// 遍历答案
		$.each($('div.answer-sheet-area>ul>li'), function(i, n){
			// 获取答案
			var answer = $(n).attr('data-answer');
			answers += answer + ',';
		});
		answers = answers.substring(0, answers.lastIndexOf(','));
		// 地址跳转
		$(window).attr('location', '/assignment?id=' + getUrlParam('id') + '&answers=' + answers);
	});
});


// 根据试卷ID与题目ID获取题目信息
function getTopicByPaperIdAndTopicId(paperId, page){
	$.get('/topic', {
		paperId: paperId,
		page: page
	}, function(json){
//		console.log(json);
		refreshTopic(json.dataList[0], page);
		
		// 判断上一题与下一题
		if (json.hasPreviousPage){
			$('button.previous').removeClass('disable');
			$('button.previous').attr('data-page', json.previousPage);
		} else {
			$('button.previous').addClass('disable');
		}
		if (json.hasNextPage){
			$('button.next').removeClass('disable');
			$('button.next').attr('data-page', json.nextPage);
		} else {
			$('button.next').addClass('disable');
		}
		$.each($('div.answer-sheet-area>ul>li[data-number=' + page + ']').siblings(), function(i, n){
			$(n).removeClass('being');
		});
		$('div.answer-sheet-area>ul>li[data-number=' + page + ']').addClass('being');
		
		// 判断是否有答案
		var answer = $('div.answer-sheet-area>ul>li.being').attr('data-answer');
		if (typeof(answer) != "undefined") {			
			$('input[value=' + answer + ']').prop("checked",'checked');
		}
		
		// 判断是否还有题目
		if (!json.hasNextPage) {
			$('button.next').remove();
			$('div.topic-switch').append('<button class="submit">交卷</button>');
		} else {
			$('button.submit').remove();
			if ($('button.next').length == 0){
				$('div.topic-switch').append('<button class="next">下一题</button>');
			}
		}
		
	}, 'json');
}

// 替换题目参数
function refreshTopic(topic, page){
	$('div.answer-area').attr('data-answer-number', page);
	$('div.topic-title>span').html('<a>' + page + '.</a>' + topic.name);
	var answerUl = $('div.answer>ul');
	answerUl.html('');
	// 遍历答案
	$.each(topic.answer, function(i, n){
		answerUl.append('<li><a>' + n.number + '</a><input type="radio" name="answer" data-number="' + page + '" value="' + n.number + '"><span>' + n.name + '</span></li>');
	});
}

// 保存答案
function saveAnswer(){
	// 遍历答案
	var answers = '';
	$.each($('div.answer-sheet-area>ul>li'), function(i, n){
		answers += $(n).attr('data-answer') + ',';
	});
	console.log(answers);
}


// 获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)'); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}