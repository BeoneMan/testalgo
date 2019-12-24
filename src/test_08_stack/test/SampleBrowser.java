package test_08_stack.test;

public class SampleBrowser {
    private String currentPage;
    private StackBaseOnLinkedList forwardList;
    private StackBaseOnLinkedList comebackList;

    public SampleBrowser() {
        this.currentPage = null;
        this.forwardList = new StackBaseOnLinkedList();
        this.comebackList = new StackBaseOnLinkedList();
    }


    public void offer(String url) {
        if (currentPage != null) {
            comebackList.push(currentPage);
            forwardList.clear();
        }
        this.currentPage = url;
    }

    public void forward() {
        if (isCanForward()) {
            comebackList.push(currentPage);
            this.currentPage = forwardList.pop().getData();
        }
        getCurrentPage();
    }

    public void comeback() {
        if (isCanComeback()) {
            forwardList.push(currentPage);
            currentPage = comebackList.pop().getData();
        }
        getCurrentPage();
    }

    public boolean isCanForward() {
        return this.forwardList.getSize() > 0;
    }

    public boolean isCanComeback() {
        return this.comebackList.getSize() > 0;
    }

    public String getCurrentPage() {
        System.out.println("当前页面是：" + currentPage);
        return currentPage;
    }


    public static void main(String[] args) {
        SampleBrowser sb = new SampleBrowser();
        sb.offer("baidu.com");
        sb.offer("chrom.com");
        sb.offer("fox.com");
        sb.offer("mail.com");
        sb.getCurrentPage();
        sb.comeback();
        sb.comeback();
        sb.forward();
        sb.offer("driveman.com");
        sb.comeback();
    }
}
