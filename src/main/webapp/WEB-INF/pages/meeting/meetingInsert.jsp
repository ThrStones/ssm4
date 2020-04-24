<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">

<!-- END SHORTCUT ICON -->
<title>小莱信息化管理系统</title>

<jsp:include page="../base/link.jsp"/>

<body onpageshow='event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();;event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();'>
	<section id="container">

<jsp:include page="../base/header.jsp"/>
<jsp:include page="../base/aside.jsp"/>

		<section id="main-content">

<section class="wrapper">
	
	<div class="row">
		<div class="col-lg-12" id="files_main">

<div class="col-md-12">
	<section class="panel">
		<header class="panel-heading">
			<span class="label label-primary">发布会议</span>
			<span class="tools pull-right"> </span>
		</header>
		<div class="panel-body">
<form novalidate="novalidate" class="form-horizontal tasi-form" method="post" id="addForm"
	  action="insert">
	<input type="hidden" name="accountId" value="${ sessionScope.loginAccount.id }">
	<div class="form-group">
		<label class="control-label col-md-3">开始时间：</label>
		<div class="col-md-3 col-xs-11">
			<input name="startTime" readonly="readonly" onclick="display()"
				   class="form-control form-control-inline input-medium "
				   style="width:160px;" id="startTime" type="text">

		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">结束时间：</label>
		<div class="col-md-3 col-xs-11">
			<input name="endTime" readonly="readonly" onclick="display()"
				   class="form-control form-control-inline input-medium default-date-picker"
				   style="width:160px;" id="endTime" type="text">

		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">标题：</label>
		<div class="col-md-3 col-xs-11">
			<input name="title" class="form-control form-control-inline input-medium default-date-picker" style="width:130px;" type="text">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">内容：</label>
		<div class="col-md-3 col-xs-11">
		 <textarea rows="5" name="content" class="wysihtml5 form-control"></textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-3">会议地址：</label>
		<div class="col-md-3 col-xs-11">
			<input name="address" class="form-control form-control-inline input-medium default-date-picker" style="width:130px;" type="text">
		</div>
	</div>

	<div class="form-actions">
		<input value="立即发布" class="btn btn-success" id="add_b111" type="submit"> &nbsp;&nbsp;&nbsp; <input value="取消" class="btn" id="cancel_b" type="button">
	</div>
</form>
		</div>
	</section>
	
</div></div>
	</div>
</section></section>
		<!-- END MAIN CONTENT -->
		<!-- BEGIN FOOTER -->
<jsp:include page="../base/footer.jsp"/>
	<!-- JQUERY KNOB JS -->
	<script>
      //knob
      $(".knob").knob();
    </script>
<script type="text/javascript">
		function display(){       
			WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
		}
</script>


</body></html>