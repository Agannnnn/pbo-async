<%@ page import="com.sultan.pbo.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>

<% NumberFormat pf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>

    <body>
        <div class="h-screen grid grid-rows-[auto_1fr] bg-gray-100 ">
            <nav class="bg-blue-600 flex flex-row justify-between items-center px-6 py-4">
                <span class="text-xl font-bold text-white">Indoapril Inventory Information System</span>
                <a href="/logout" class="px-4 py-2 border border-gray-100 rounded text-white">Logout</a>
            </nav>
            <main class="mx-8 my-6 bg-white rounded-xl px-4 py-2 flex flex-col gap-4">
                <h1 class="text-4xl font-bold">Inventory</h1>
                <div class="grid grid-cols-[1fr_auto] gap-4">
                    <section class="flex flex-col gap-4">
                        <form action="/" method="GET" class="grid grid-cols-[1fr_auto] gap-2 w-full">
                            <input type="text" name="q" class="px-4 py-2 border rounded-lg" />
                            <button type="submit" class="bg-blue-800 text-white border rounded-lg px-4 w-fit">Find item</button>
                        </form>
                        <table class="table-auto w-full rounded-lg overflow-clip">
                            <thead class="text-left bg-blue-600 text-white">
                                <tr class="border-b border-gray-800">
                                    <th class="px-4 py-2">No</th>
                                    <th class="px-4 py-2">Item Name</th>
                                    <th class="px-4 py-2">Qty</th>
                                    <th class="px-4 py-2">Price / pcs</th>
                                    <th class="px-4 py-2">Total Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% ArrayList< Product> products = (ArrayList<Product>) request.getAttribute("products");%>
                                <%if (products != null) { %>
                                <%for (Product product : products) {%>
                                <tr class="border-b border-gray-200">
                                    <td class="px-4 py-2"><%= product.getNo()%></td>
                                    <td class="px-4 py-2"><%= product.getName()%></td>
                                    <td class="px-4 py-2"><%= product.getQty()%></td>
                                    <td class="px-4 py-2"><%= pf.format(product.getPrice())%></td>
                                    <td class="px-4 py-2"><%= pf.format(product.getTotalPrice())%></td>
                                </tr>
                                <% }%>
                                <%}%>
                            </tbody>
                        </table>
                    </section>
                    <section>
                        <form action="/product" method="POST">
                            <div class="flex flex-col gap-4">
                                <div class="flex flex-col gap-2">
                                    <label for="no">No</label>
                                    <input type="text" name="no" required class="rounded-lg border px-4 py-2" />
                                </div>
                                <div class="flex flex-col gap-2">
                                    <label for="name">Product Name</label>
                                    <input type="text" name="name" required class="rounded-lg border px-4 py-2" />
                                </div>
                                <div class="flex flex-col gap-2">
                                    <label for="qty">Stock Quantity</label>
                                    <input type="number" name="qty" required class="rounded-lg border px-4 py-2" />
                                </div>
                                <div class="flex flex-col gap-2">
                                    <label for="price">Item Price / pcs</label>
                                    <input type="number" step="0.05" name="price" required class="rounded-lg border px-4 py-2" />
                                </div>
                                <button type="submit" class="rounded-lg bg-blue-600 py-2 text-white">Save product</button>
                            </div>
                        </form>
                    </section>
                </div>
            </main>
        </div>
    </body>
</html>