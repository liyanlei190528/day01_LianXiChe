package com.example.day02_lianxiche.bean;

import java.util.List;

public class ZhiHuDetailBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title"></h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/da8e974dc_is.jpg">
     <span class="author">知乎用户，</span><span class="bio">哪能跟烧饼讲道理呀</span>
     </div>

     <div class="content">
     <p>目前认为主要通过三种机制：</p><p>ITD（interaural time difference）</p><p>ILD（interaural level difference）</p><p>和pinna cues （spectral cues）</p><p>———————人懒更慢的分割线———————</p><p>ITD ： 顾名思义是来自同一声源的声音，到达双耳的时间区别。</p><img src="http://pic4.zhimg.com/70/v2-83fd50be9b60fe2245dde0c485ce1f9f_b.jpg" data-width="1365" data-height="1024"><p>因为人头是有体积的嘛，所以声音到达左右耳根据声源的不同位置就会有不同的时间差。然后由于听神经对声音fine-structure的相锁（phase lock），就可以通过对比来自两侧耳朵的神经输入知道这个时间差，从而判断声源位置。</p><p>ILD，也顾名思义，就是同一声源的声音到达两个耳朵的音量区别。离得近的大声离得远的小声，要是非常偏向左右中的某一侧还会被脑袋阻挡，另一侧接收到的声音就更小了。</p><p>最后这个pinna cue，就是声音在你外耳产生的反射啦，举个例子：</p><img src="http://pic2.zhimg.com/70/v2-82493fb0a5c3831a8fad7dc0085ede8d_b.jpg" data-width="343" data-height="293"><p>下面两张图就是来自不同方向的声音经过外耳反射之后产生的频率响应，可以看到，来自前方的声音在10kHz处会被削减很多哈。</p><p>这个pinna cue虽然人和人之间有一定的相似，但实际上是因人而异的，如何更好的测量和表示它，在以虚拟现实为主的音频技术里面还是蛮重要的。</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/333250737">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div><script type=“text/javascript”>window.daily=true</script>
     * image_source : Anemone123 / CC0
     * title : 人的听觉系统是怎样对声音进行定位的？
     * image : https://pic3.zhimg.com/v2-95e4632978715690366e4cc65adf75ba.jpg
     * share_url : http://daily.zhihu.com/story/9713210
     * js : []
     * ga_prefix : 071016
     * images : ["https://pic1.zhimg.com/v2-3042d71e26652bb773debf6576464564.jpg"]
     * type : 0
     * id : 9713210
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<String> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getJs() {
        return js;
    }

    public void setJs(List<String> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
