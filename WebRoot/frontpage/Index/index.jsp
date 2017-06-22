<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>WESTINNO-首页</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/index.css"/>
    <style type="text/css">
      .bar_content_list{
        cursor: pointer;
      }
    </style>
</head>
<body>
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />
<!--中间blank、导航-->
<div class="mid_bar">
    <div class="play_pic1">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <img src="<%=basePath%>frontpage/images/bar1.png" alt=""/>
                </div>
                <div class="swiper-slide">
                    <img src="<%=basePath%>frontpage/images/bar2.png" alt=""/>
                </div>
                <!-- <div class="swiper-slide">
                    <img src="<%=basePath%>frontpage/images/bar1.jpg" alt=""/>
                </div>
                <div class="swiper-slide">
                    <img src="<%=basePath%>frontpage/images/bar2.jpg" alt=""/>
                </div> -->
            </div>
        </div>
    </div>
    <div class="bar_main">
        <div class="bar_content">
            <div class="bar_content_show">
                <!--<div class="bar_back"></div>-->
                <div class="bar_left">
                    <div class="bar_content_list service_btn">
                        <div class="bar_back"></div>
                        <div class="bar_content_list_main" onclick="location.href='productShow-3.html'">
                            <div class="bar_icon">
                                <div class="bar_icon_show">
                                    <img src="<%=basePath%>frontpage/images/shuangchuang_black.png" alt=""/>
                                    <img src="<%=basePath%>frontpage/images/shuangchuang_white.png" alt=""/>
                                </div>
                            </div>
                            <div class="bar_type">
                                <div class="bar_type_top">
                                    <span>双创服务</span>
                                </div>
                                <div class="bar_type_bottom">
                                    <span>服务费：</span><i>500</i> <span>起</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bar_content_list knowledge_btn">
                        <div class="bar_back"></div>
                        <div class="bar_content_list_main" onclick="location.href='productShow-1.html'">
                            <div class="bar_icon">
                                <div class="bar_icon_show">
                                    <img src="<%=basePath%>frontpage/images/zhishi_black.png" alt=""/>
                                    <img src="<%=basePath%>frontpage/images/zhishi_white.png" alt=""/>
                                </div>
                            </div>
                            <div class="bar_type">
                                <div class="bar_type_top">
                                    <span>专利服务</span>
                                </div>
                                <div class="bar_type_bottom">
                                    <span>服务费：</span><i>6150</i> <span>起</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bar_content_list project_btn">
                        <div class="bar_back"></div>
                        <div class="bar_content_list_main" onclick="location.href='productShow-2.html'">
                            <div class="bar_icon">
                                <div class="bar_icon_show">
                                    <img src="<%=basePath%>frontpage/images/xiangmu_black.png" alt=""/>
                                    <img src="<%=basePath%>frontpage/images/xiangmu_white.png" alt=""/>
                                </div>
                            </div>
                            <div class="bar_type">
                                <div class="bar_type_top">
                                    <span>商标服务</span>
                                </div>
                                <div class="bar_type_bottom">
                                    <span>服务费：</span><i>900</i> <span>起</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bar_content_list service_btn">
                        <div class="bar_back"></div>
                        <div class="bar_content_list_main" onclick="location.href='productShow-2.html'">
                            <div class="bar_icon">
                                <div class="bar_icon_show">
                                    <img src="<%=basePath%>frontpage/images/banquan_black.png" alt=""/>
                                    <img src="<%=basePath%>frontpage/images/banquan_white.png" alt=""/>
                                </div>
                            </div>
                            <div class="bar_type">
                                <div class="bar_type_top">
                                    <span>版权服务</span>
                                </div>
                                <div class="bar_type_bottom">
                                    <span>服务费：</span><i>800</i> <span>起</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
    </div>
</div>

<!--选择我们的原因-->
<div class="choice_main">
    <div class="choice_content">
        <div class="choice_top">
            <div class="mid_line"></div>
            <div class="choice_word_content">
                <div class="choice_word">
                    <h1>热门推荐</h1>
                    <span>Hot Recommend</span>
                </div>
            </div>
        </div>
        <div class="choice_show">
            <div class="choice_list">
                <div class="choice_list_pic">
                    <img src="<%=basePath%>frontpage/images/experience.png" alt=""/>
                </div>
                <div class="choice_list_word">
                    <span>企业初创</span>
                </div>
                <div class="choice_list_dic">
                    <p>公司注册、代理记账、合同审写</p>
                    <p>西创服务中心通通为你搞定</p>
                </div>
                <div class="order_shunxu">
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>公司注册</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>代理记账</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>合同审写</span>
                    </div>
                </div>
            </div>
            <div class="choice_list">
                <div class="choice_list_pic">
                    <img src="<%=basePath%>frontpage/images/plan.png" alt=""/>
                </div>
                <div class="choice_list_word">
                    <span>成长初期</span>
                </div>
                <div class="choice_list_dic">
                    <p>商标注册、专利申请、版权登记</p>
                    <p>助力企业布局知识产权战略体系</p>
                </div>
                <div class="order_shunxu">
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>商标注册</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>专利申请</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>版权登记</span>
                    </div>
                </div>
            </div>
            <div class="choice_list">
                <div class="choice_list_pic">
                    <img src="<%=basePath%>frontpage/images/platform.png" alt=""/>
                </div>
                <div class="choice_list_word">
                    <span>稳步发展</span>
                </div>
                <div class="choice_list_dic">
                    <p>项目申报、税收筹划、审计验资</p>
                    <p>精细化企业发展相应需求</p>
                </div>
                <div class="order_shunxu">
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>项目申报</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>税收筹划</span>
                    </div>
                    <div class="order_shunxu_list">
                        <img src="<%=basePath%>frontpage/images/u288.png" alt=""/>
                        <span>审计验资</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--听他们怎么说-->
<div class="listen_main">
    <div class="listen_content">
        <div class="listen_content_head">
            <h1>用户评价</h1>
        </div>
        <div class="say_word_main">
            <div class="say_word">
                <div class="say_word_content">
                    <span>在没有接触到WESTINNO前，觉得创业扶持的都是政府在做政绩工程，自从和他们接触以来，我们才了解到双创是真正落实到我们创业人群中的巨大利好，希望WESTINNO继续一如既往的帮助我们这样的小企业。</span>
                    <span>西创服务中心的团队很好，服务到位，在知识产权上帮助我们解决了许多问题，是值得信赖的企业服务平台。</span>
                    <span>在公司注册和财务方面西创中心提供的服务对于初创企业来说是非常好的，在团队创业初期的确帮助我们解决了很多困惑和问题，提供的服务也超出了我们的预期。</span>
                    <span>西创服务中心很好地帮助了创业初期团队解决一些列的财务、工商等方面的问题，让我们能够把重心放到产品的研发和开拓市场上，是非常值得推荐的创业合作伙伴！</span>
                </div>
            </div>
            <div class="sanjiao_white"></div>
        </div>
        <div class="say_person">
            <div class="say_person_content">
                <div class="say_person_main">
                	<div class="say_person_list">
                        <div class="person_pic">
                            <img src="<%=basePath%>frontpage/images/pic4.jpg" alt=""/>
                        </div>
                        <div class="person_name">
                            <span>李沁宇</span>
                        </div>
                        <div class="person_company">
                            <span>成都逸桥科技有限公司 CEO</span>
                        </div>
                    </div>
                    <div class="say_person_list">
                        <div class="person_pic">
                            <img src="<%=basePath%>frontpage/images/pic1.jpg" alt=""/>
                        </div>
                        <div class="person_name">
                            <span>辰力</span>
                        </div>
                        <div class="person_company">
                            <span>四川天华股份有限公司 CEO</span>
                        </div>
                    </div>
                    <div class="say_person_list">
                        <div class="person_pic">
                            <img src="<%=basePath%>frontpage/images/pic2.jpg" alt=""/>
                        </div>
                        <div class="person_name">
                            <span>miss_冰</span>
                        </div>
                        <div class="person_company">
                            <span>成都永康制药有限公司 CEO</span>
                        </div>
                    </div>
                    <div class="say_person_list">
                        <div class="person_pic">
                            <img src="<%=basePath%>frontpage/images/pic3.jpg" alt=""/>
                        </div>
                        <div class="person_name">
                            <span>辛韵</span>
                        </div>
                        <div class="person_company">
                            <span>成都泰格微波技术股份有限公司 CEO</span>
                        </div>
                    </div>
                </div>
                <button class="button_prev say_btn">
                    <img src="<%=basePath%>frontpage/images/u97.png" alt=""/>
                </button>
                <button class="button_next say_btn">
                    <img src="<%=basePath%>frontpage/images/u98.png" alt=""/>
                </button>
            </div>
        </div>
    </div>
</div>

<!--服务宗旨-->
<div class="service_aim">
    <div class="service_aim_content">
        <div class="service_aim_left">
            <div class="service_aim_pic">
                <img src="<%=basePath%>frontpage/images/u340.png" alt=""/>
            </div>
            <div class="service_aim_dic">
                <p>WESTINNO</p>
                <p>服务宗旨</p>
            </div>
        </div>
        <div class="service_aim_right">
            <p>深挖企业价值，关怀培育企业成长的每一阶段，打造聚合西部地区创新创业资源的综合性服务平台是西部创新创业服务中的服务宗旨。通过运用互联网的力量，以快速、高效、专业的服务态度积极响应客户的需求，关注企业成长，深挖企业价值，从而达到建设基于“互联网+”形态下的综合性企业服务平台的目标，为更多企业提供全方位的创新创业服务。</p>
        </div>
    </div>
</div>

<!--看看我们的伙伴-->
<div class="look_main">
    <div class="look_content">
        <div class="choice_top">
            <div class="mid_line"></div>
            <div class="choice_word_content">
                <div class="choice_word" style="background-color: #ffffff;">
                    <h1>合作伙伴</h1>
                    <span>OUR COOPERATION COMPANY</span>
                </div>
            </div>
        </div>
        <div class="brand_main">
            <div class="brand_content">
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/s2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/s1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/D2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/D1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/N2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/N1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/E2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/E1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/Z2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/Z1.png" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="brand_content">
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/G2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/G1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/H2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/H1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/SS2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/SS1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/c2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/c1.png" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="brand_list">
                    <div class="brand_list_content">
                        <div class="brand_list_show">
                            <img src="<%=basePath%>frontpage/images/F2.png" alt=""/>
                            <img src="<%=basePath%>frontpage/images/F1.png" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--West信息-->
<div class="info_main">
    <div class="info_content">
        <div class="info_logo">
            <img src="<%=basePath%>frontpage/images/west2.png" alt=""/>
        </div>
        <div class="info_time">
            <span>一站式创业服务平台</span>
        </div>
        <div class="info_num">
            <div class="info_num_list">
                <span>服务企业1500+家</span>
            </div>
            <div class="info_num_list">
                <span>7*24小时售后服务支持</span>
            </div>
            <div class="info_num_list">
                <span>互联网化的服务平台</span>
            </div>
        </div>
        <div class="feature">
            <div class="feature_list">

            </div>
        </div>
    </div>
</div>

<!--底部链接-->
<jsp:include page="../include/foot.jsp" />

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/index.js"></script>
</body>
</html>