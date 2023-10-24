<%@ page import="java.util.List" %>
<%@ page import="com.gathergrid.gathergridfeatures.utils.DateUtil" %>
<%@ page import="com.gathergrid.gathergridfeatures.domain.Event" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.6.5/flowbite.min.css" rel="stylesheet" />
<%--        <script src="https://cdn.tailwindcss.com"></script>--%>
        <style>
            .logo-color {
                font-weight: bold;
                color: #e60023;
                font-size: 22px;
                padding-top: 4px;
                letter-spacing: 1.3px;
                background-image: linear-gradient(to right, #a61a71, #e02b60);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                background-clip: text;
                -webkit-text-fill-color: transparent;
            }

            #jobs-home nav {
                display: flex;
                align-items: center;
                justify-content: space-between;
                background: #fff;
                padding: 15px 15px 10px 30px;
                border-bottom: 3px solid #e02b60;
                position: fixed;
                width: 100%;
                z-index: 1;
            }
            #jobs-home nav .search {
                display: flex;

                position: relative;
            }
            #jobs-home nav .search i {
                margin-right: 14px;
                position: absolute;
                color: #aeb2ba;
                top: 12px;
                left: 12px;
            }
            #jobs-home nav .search input {
                border: none;
                outline: none;
                font-size: 14px;
                justify-content: flex-start;
                align-items: center;
                border: 2px solid #d7dbe6;
                border-radius: 24px;
                height: 40px;
                width: 61vw;
                padding: 10px 10px 13px 33px;
            }
            #jobs-home nav .profile {
                display: flex;
                justify-content: flex-start;
                align-items: center;
            }
            #jobs-home nav .profile .notification {
                margin-right: 20px;
                font-size: 20px;
                cursor: pointer;
            }
            #jobs-home nav .profile .notification:hover {
                cursor: pointer;
            }
            #jobs-home nav .profile img {
                width: 25px;
                height: 25px;
                margin-left: 6px;
                border-radius: 50%;
                object-fit: cover;
            }
            .n1 {
                display: flex;
                justify-content: center;
                align-items: center;
            }
            #menu-bar {
                display: none;
                color: #2b2b2b;
                font-size: 20px;
                cursor: pointer;
                margin-right: 20px;
            }
            @media (max-width: 769px) {
                #menu-bar {
                    display: initial;
                }
                #jobs-home {
                    width: 100%;
                    margin-left: 0px;
                    display: inline-block;
                }
                #jobs-home .navigation {
                    width: 100%;
                }
                .values {
                    padding: 30px 30px 0 30px;
                    justify-content: flex-start;
                }
            }
            @media (max-width: 586px) {
                #jobs-home nav {
                    padding: 15px;
                }
                #jobs-home nav .search input {
                    width: 150px;
                }
            }
        </style>
    </head>
    <body>
        <script src="https://cdn.tailwindcss.com"></script>
        <c:import url="../components/navBar.jsp" />
        <div class="container mx-auto p-10">
            <!-- filter -->
<form class="flex flex-col">
    <div class="bg-white p-6 rounded-xl shadow-lg">
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
            <!-- From Date -->
            <div class="flex flex-col">
                <label for="fromDate" class="font-medium text-sm text-stone-600">From Date</label>
                <input
                    type="date"
                    id="fromDate"
                    class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                    name="fromdate"
                />
            </div>

            <!-- To Date -->
            <div class="flex flex-col">
                <label for="toDate" class="font-medium text-sm text-stone-600">To Date</label>
                <input
                    type="date"
                    id="toDate"
                    class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                    name="todate"
                />
            </div>

            <!-- Text Input -->
            <div class="flex flex-col">
                <label for="textFilter" class="font-medium text-sm text-stone-600">Text Filter</label>
                <input
                    type="text"
                    id="textFilter"
                    class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                    name="text"
                />
            </div>
            <div class="flex flex-col">
                <label
                        for="status"
                        class="font-medium text-sm text-stone-600"
                >Category</label>

                <select
                        id="status"
                        class="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
                        name="category"
                >
                    <option value="">None</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="grid md:flex grid-cols-2 justify-end space-x-4 w-full mt-6">
            <button
                    class="px-4 py-2 rounded-lg text-stone-50 bg-stone-400 hover:bg-stone-500 font-bold text-white shadow-lg shadow-stone-200 transition ease-in-out duration-200 translate-10"
                    type="submit"
                    name="reset"
            >
                Reset
            </button>

            <button
                    class="px-4 py-2 rounded-lg text-orange-50 bg-orange-400 hover:bg-orange-500 font-bold text-white shadow-lg shadow-orange-200 transition ease-in-out duration-200 translate-10"
                    type="submit"
                    name="search"
            >
                Search
            </button>
        </div>
    </div>
</form>

            <div class="flex flex-wrap -mx-4">
                <%
                    List<Event> events = (List<Event>) request.getAttribute("events");
                    for (Event event: events) {
                %>
                <!-- Card -->
                <a href="#" class="w-full sm:w-1/2 lg:w-1/3 p-4">
                    <div class="max-w-sm rounded overflow-hidden shadow-lg hover:bg-gray-200">
                        <img
                                class="w-full"
                                src="images/card-top.jpg"
                                alt="Sunset in the mountains"
                        />
                        <div class="px-6 py-4">
                            <div class="font-bold text-xl mb-2">
                                <%=event.getName()%>
                            </div>
                            <div class="flex items-center justify-between text-gray-500 text-sm">
                                <span class="bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">
                                    #<%=event.getCategory().getName()%>
                                </span>
                                <span class="py-1 mb-2">
<%--                                    Date: October 19, 2023--%>
                                    Date: <%=DateUtil.getDate(event.getDate())%>
                                </span>
                            </div>
                            <p class="text-gray-700 text-base">
                                <%=event.getDescription()%>
<%--                                Lorem ipsum dolor sit amet, consectetur--%>
<%--                                adipisicing elit. Voluptatibus quia, nulla!--%>
<%--                                Maiores et perferendis eaque, exercitationem--%>
<%--                                praesentium nihil.--%>
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
                <%
                    }
                %>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.6.5/flowbite.min.js"></script>
    </body>
</html>
