# Proyek Penerapan MVC Pada Java Servlet + JSP

Dibuat oleh: Sultan Ahmad

Dengan keterbatasan sistem operasi yang saya gunakan, saya menggunakan Docker dan bukan XAMPP untuk menjalankan server Tomcat.

## Penggunaan AI

Pembuatan proyek ini tanpa melalui bantuan AI sama sekali. Berikut adalah sumber referensi yang saya akses dalam pembuatannya:

- Tutorial JSP: https://www.baeldung.com/jsp
- Tutorial JSP: https://www.tutorialspoint.com/jsp/index.htm
- Tutorial menjalankan Tomcat melalui Docker: https://www.jetbrains.com/help/idea/docker-tutorial-tomcat-debug.html

## Cara menjalankan

1. Download dan install Docker.
2. Download dan install mvn (opsional)
3. Jalankan `sudo docker compose down`
4. Jalankan `mvn clean package` atau build proyek pada Netbeans
5. Jalankan `sudo docker compose up --build -d`
6. Buka website pada `localhost:8080`