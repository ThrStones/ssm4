<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside>
    <div tabindex="5000" style="overflow: hidden;" id="sidebar" class="nav-collapse">
        <ul class="sidebar-menu" id="nav-accordion">
            <li>
                <a href="#" class="active">
                    <span> 主页 </span>
                </a>
            </li>
            <li class="sub-menu dcjq-parent-li">
                <a class="dcjq-parent" href="javascript:show(0);">
                    <span> [系统信息管理] </span>
                    <span class="dcjq-icon"></span>
                </a>
<ul style="display: block;" id="sub_0" class="sub">
    <li>
        <a href="/emp/empList?pageNum=1" title="员工管理">员工管理</a>
    </li>
    <li>
        <a href="/meeting/meetingList?pageNum=1" title="会议管理">会议管理</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/dept/deptList?pageNum=1" title="部门管理">部门管理</a>
    </li>
</ul>
            </li>
        </ul>
    </div>
</aside>
