# NotificationStyles
## Install

Now it's available on jcenter.

With Gradle:

```groovy
compile 'com.github.boybeak:notify:1.3.1'
```

With Maven:

```xml
<dependency>
  <groupId>com.github.boybeak</groupId>
  <artifactId>notify</artifactId>
  <version>1.3.1</version>
  <type>pom</type>
</dependency>
```

## NotificationCenter

With this library, you can show a notification simply like belows:

```java
NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Messaging ContentText")
                .contentTitle("Messaging ContentTitle")
                .ticker("Messaging Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asBigPictureStyle()
                .bigContentTitle("InboxStyle bigContentTitle")
                .summaryText("InboxStyle summaryText")
                .bigLargeIcon(iconBmp)
                .bigPicture(picture)
                .show(4);
```

There are 4 styles for you,  **BigPicture**, **BigText**, **Inbox** and **Messaging**. And also you can define your own Style, see the demo style [AsyncBigPicture.java](https://github.com/boybeak/NotificationStyles/blob/master/app/src/main/java/com/nulldreams/notificationstyles/AsyncBigPicture.java).

To use this custom style, you need call asStyle method of NotificationCenter.

> Now, MediaStyle still not finished.

## ToastCenter

Simply like this:

```java
ToastCenter.with(this).text(R.string.toast, "Alice").showShort();
```

With this, you can pass parameters directly.



<img src="https://github.com/boybeak/NotificationStyles/blob/master/main.png" width=180 height=320/>
<img src="https://github.com/boybeak/NotificationStyles/blob/master/big_text.png" width=180 height=320/>
<img src="https://github.com/boybeak/NotificationStyles/blob/master/big_picture.png" width=180 height=320/>
<img src="https://github.com/boybeak/NotificationStyles/blob/master/inbox.png" width=180 height=320/>
<img src="https://github.com/boybeak/NotificationStyles/blob/master/messaging.png" width=180 height=320/>
