# myapi/urls.py

from django.urls import include, path
from rest_framework import routers
from . import views


# Wire up our API using automatic URL routing.
# Additionally, we include login URLs for the browsable API.
urlpatterns = [
    path('usage/add', views.addUsage, name='addUsage'),
    path('usage/current-day', views.getCurrentDay, name='getCurrentDay'),
    path('usage/last-days', views.getLastDays, name='getLastDays')
]