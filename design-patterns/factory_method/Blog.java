package factory_method;

public class Blog extends Website {
    @Override
    public void createWebSite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
