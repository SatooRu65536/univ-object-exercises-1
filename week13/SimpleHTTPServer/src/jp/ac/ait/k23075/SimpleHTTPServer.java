package jp.ac.ait.k23075;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {
  static final String html = """
      <!DOCTYPE html>
      <html lang="ja">
        <head>
          <meta charset="utf-8" />
          <title>🐧</title>

          <link rel="stylesheet" href="style.css" />
          <script src="script.js" defer></script>
        </head>

        <body>
          <div class="center-wrapper">
            <p id="penguin" class="item">🐧</p>
            <h1 id="message" class="message">ペンギンを愛でよ</h1>
            <button id="push" class="push">Push!!</button>
          </div>

          <div id="bg" class="bg"></div>
        </body>
      </html>
      """;
  static final String css = """
      @keyframes rotation {
        0% {
          transform: rotate(0deg);
        }

        100% {
          transform: rotate(360deg);
        }
      }

      * {
        margin: unset;
        padding: unset;
        box-sizing: border-box;
      }

      .center-wrapper {
        height: 100vh;
        position: relative;
      }

      .item,
      .message,
      .push {
        height: fit-content;
        width: fit-content;
        position: absolute;
        inset: 0;
        margin: auto;
        z-index: 1;
        font-size: 50px;
      }

      .message {
        top: 150px;
        display: none;
      }

      .push {
        font-size: 25px;
        padding: 5px 10px;
      }

      .bg {
        position: fixed;
        width: 200vw;
        height: 200vw;
        left: calc(50% - 100vw);
        top: calc(50% - 100vw);
        background-image: repeating-conic-gradient(transparent 0,
            transparent 13deg,
            #ffab3c 13deg,
            #ffab3c 16deg),
          repeating-conic-gradient(transparent 0,
            transparent 20deg,
            #ffab3c 20deg,
            #ffab3c 23deg),
          repeating-conic-gradient(transparent 0,
            transparent 5deg,
            #ffab3c 5deg,
            #ffab3c 8deg),
          repeating-conic-gradient(transparent 0,
            transparent 40deg,
            #ffab3c 40deg,
            #ffab3c 44deg),
          repeating-conic-gradient(transparent 0,
            transparent 10deg,
            #ffab3c 10deg,
            #ffab3c 13deg);
        animation: rotation 20s linear infinite;
        display: none;
      }
      """;
  static final String js = """
      const push = document.getElementById("push");
      push.addEventListener("click", handleClick);

      function handleClick() {
      const bg = document.getElementById("bg");
      const penguin = document.getElementById("penguin");
      const message = document.getElementById("message");

      push.style.display = "none";
      bg.style.display = "block";
      penguin.style.display = "block";
      message.style.display = "block";
      document.body.style.backgroundColor = "#ffee33";
      }
      """;

  public static void main(String[] args) throws Exception {

    try (ServerSocket ss = new ServerSocket(8088)) {
      while (true) {
        Socket s = ss.accept();
        var in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = in.readLine();
        String requestPath = line.split(" ")[1];

        if (requestPath.endsWith(".css")) {
          String res = "HTTP/1.1 200 OK\nContent-Type: text/css\n\n" + css;
          s.getOutputStream().write(res.getBytes());
        } else if (requestPath.endsWith(".js")) {
          String res = "HTTP/1.1 200 OK\nContent-Type: text/javascript\n\n" + js;
          s.getOutputStream().write(res.getBytes());
        } else {
          String res = "HTTP/1.1 200 OK\nContent-Type: text/html\n\n" + html;
          s.getOutputStream().write(res.getBytes());
        }

        s.close();
      }
    }
  }
}
