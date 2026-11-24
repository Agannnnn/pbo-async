<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body>
    <main class="w-screen h-screen flex justify-center items-center bg-slate-100">
        <div class="border rounded-lg shadow bg-white p-4 min-w-[320px]">
            <div class="flex flex-col gap-4">
                <h1 class="text-4xl font-bold text-center">LOGIN</h1>
                <jsp:scriptlet>
                    if (request.getSession().getAttribute("errors") != null) {
                </jsp:scriptlet>
                <div class="bg-red-200 px-4 py-2 my-2 rounded-md">
                    <span class="text-red-800">
                        <jsp:expression>
                            request.getSession().getAttribute("errors")
                        </jsp:expression>
                    </span>
                </div>
                <jsp:scriptlet>
                    }
                </jsp:scriptlet>
                <form action="/login" method="post" class="flex flex-col gap-2">
                    <div class="flex flex-col gap-2">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" class="border rounded-md px-4 py-2"
                            placeholder="user@example.com">
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" class="border rounded-md px-4 py-2">
                    </div>
                    <button class="bg-green-400 text-white px-4 py-2 rounded-md" type="submit">Login</button>
                </form>
                <span class="text-center text-gray-800">
                    Atau <a href="/register" class="text-blue-600 underline">buat</a> akun baru
                </span>
            </div>
        </div>
    </main>
</body>

</html>