<%@ page import="com.gathergrid.gathergridfeatures.service.CategoryService" %>
<%@ page import="com.gathergrid.gathergridfeatures.domain.Category" %>
<%@ page import="java.util.List" %>
<script src="https://cdn.tailwindcss.com"></script>
<div class="container mx-auto p-10">
    <!-- filter -->
    <div class="flex flex-col">
        <div class="bg-white p-6 rounded-xl shadow-lg">
            <div
                    class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6"
            >
                <div class="flex flex-col">
                    <label
                            for="date"
                            class="font-medium text-sm text-stone-600"
                    >Date</label
                    >
                    <input
                            type="date"
                            id="date"
                            class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                    />
                </div>

                <div class="flex flex-col">
                    <label
                            for="status"
                            class="font-medium text-sm text-stone-600"
                    >Category</label
                    >

                    <select
                            id="status"
                            class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                    >
<%--&lt;%&ndash;                        &lt;%&ndash;%>--%>
<%--//                            CategoryService categoryService = new CategoryService();--%>
<%--//                            List<Category> categories = categoryService.getAllCategories();--%>
<%--&lt;%&ndash;                        %>&ndash;%&gt;--%>
                        <option>Active</option>
                        <option>Pending</option>
                        <option>Deleted</option>
                    </select>
                </div>
            </div>

            <div
                    class="grid md:flex grid-cols-2 justify-end space-x-4 w-full mt-6"
            >
                <button
                        class="px-4 py-2 rounded-lg text-stone-50 bg-stone-400 hover:bg-stone-500 font-bold text-white shadow-lg shadow-stone-200 transition ease-in-out duration-200 translate-10"
                >
                    Reset
                </button>

                <button
                        class="px-4 py-2 rounded-lg text-orange-50 bg-orange-400 hover:bg-orange-500 font-bold text-white shadow-lg shadow-orange-200 transition ease-in-out duration-200 translate-10"
                >
                    Search
                </button>
            </div>
        </div>
    </div>
    <div class="flex flex-wrap -mx-4">
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
        <!-- Card -->
        <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
            <div
                    class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200"
            >
                <img
                        class="w-full"
                        src="images/card-top.jpg"
                        alt="Sunset in the mountains"
                />
                <div class="px-6 py-4">
                    <div class="font-bold text-xl mb-2">
                        London Music Concert
                    </div>
                    <div
                            class="flex items-center justify-between text-gray-500 text-sm"
                    >
                                <span
                                        class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"
                                >#Music</span
                                >
                        <span class="py-1 mb-2"
                        >Date: October 19, 2023</span
                        >
                    </div>
                    <p class="text-gray-700 text-base">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Voluptatibus quia, nulla!
                        Maiores et perferendis eaque, exercitationem
                        praesentium nihil.
                    </p>
                    <div class="mt-4 flex items-center">
                        <div class="text-yellow-400 text-2xl pr-2">
                            ★★★★☆
                        </div>
                        <span class="text-gray-500 text-sm"
                        >4.0 (24 reviews)</span
                        >
                    </div>
                </div>
                <div class="px-6 pt-4 pb-2"></div>
            </div>
        </a>
    </div>
</div>