package hello.core.lifelycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생설자 호출, url: " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call: + " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("clsoe: " + url);
    }


    //아래 두 방법은 지금은 사용하지 않는다.
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
