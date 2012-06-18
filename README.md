PhotoSharing
------------
<i>Share photos with your friends following a few basic steps.</i>

## Description
Went on a trip with your friends and you want to exchange your photos? Have you ever been on an event where you were the only one with a camera?
The PhotoSharing utility helps you quickly share photos with your friends. It adds all the photos in an archive, uploads them to your Dropbox account and sends an email with the download link to all your friends. You can even choose to resize the images or compress them before creating the archive. Email accounts currently supported for sharing the download link are Gmail and Hotmail.

## Usage

Add files/folders
-----------------
To start, press the Add button. You can select as many image files and folders as you want. You can clear the list anytime by pressing the Clear button.

Resize and Compress
-------------------
Next, you have the option of resizing the images, by checking the Resize checkbox and specifying a width and height value. Please note that resizing the images will result in the resizing of your actual files. Expect data loss when using this functionality. Then, you can place your photos in an archive, with the option of compressing them first. You must specify the filename for the archive to be saved, or overwrite an existing one. Just press the Browse button to find an archive. If you also want compression, you must select the Compress? checkbox. The PhotoSharing utility currently supports only .zip archives.

Upload and Share
----------------
All the images will be uploaded to your Dropbox account. All you have to do is specify your Dropbox username and password and as soon as the upload is complete, the download link will show up. The download link will be sent to as many friends as you want. Just select your email account type from the dropdown menu, fill in your username and password, add the email's recipients (as comma separated values) and an optional subject for the email. Currently, only Gmail and Hotmail accounts are supported by the PhotoSharing utility. 

When you are done with selections, just press the Go button, sit back and let the app do its work. You can clear your selections anytime, by pressing the Reset button.

## Dependencies
The source code depends on the [Google Guava Libraries](http://code.google.com/p/guava-libraries/) v11.0.2 for the application's events functionality. Actually, only a working [EventBus](http://code.google.com/p/guava-libraries/wiki/EventBusExplained) portion is required. For mailing functionality you need the [JavaMail](http://www.oracle.com/technetwork/java/javamail/index.html) library v1.4.4. For Dependency Injection I've used [Google Guice](http://code.google.com/p/google-guice/) v3.0. If you want to run the tests you need [JUnit](http://www.junit.org/). I used v4.0.

## DISCLAIMER
*I will not be responsible for any data loss or privacy infringement when using this app. Data concerning your email and dropbox account will be (ab)used. Be extra cautious when resizing files, there is no turning back!*

## TODOs
- Add dropbox support
- Log exceptions to file
- Minor layout/functionality changes

