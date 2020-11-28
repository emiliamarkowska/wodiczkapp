# from django.shortcuts import render
from django.http import HttpResponse, HttpResponseBadRequest, JsonResponse
from . import models
from django.views.decorators.csrf import csrf_exempt
import datetime
from django.db.models import Count

polandDraughtConst = 1000000 / 365 * 92 / 39000
polandNormalConst = 1800000 / 365 * 92 / 39000
europeConst = 4500000 / 365 * 92 / 39000

@csrf_exempt
def addUsage(request):
    if request.method == 'POST':
        usage = models.Usage.objects.create_usage()
        return HttpResponse('')
    else:
        return HttpResponseBadRequest()

def getCurrentDay(request):
    if request.method == 'GET':
        today = datetime.date.today()
        totalLiters = models.Usage.objects.filter(datetime__date=today).count()
        return JsonResponse({
            'totalLiters': totalLiters,
            'ratio': {
                'polandDraught': totalLiters / polandDraughtConst,
                'polandNormal': totalLiters / polandNormalConst,
                'europe': totalLiters / europeConst
            }
            })
    else:
        return HttpResponseBadRequest()

def getLastDays(request):
    if request.method == 'GET':
        days_amount = request.GET.get('amount', '0')
        today = datetime.date.today()
        start_date = today - datetime.timedelta(days=int(days_amount))
        lasts = models.Usage.objects.filter(datetime__date__range=(start_date, today)).values('datetime__date').annotate(count=Count('id')).values('datetime__date', 'count').order_by('datetime__date')

        resp = {
            'total': 0,
            'days': []
        }

        for i, el in enumerate(lasts):
            resp['days'].append({
                'id': i,
                'date': el['datetime__date'],
                'total': el['count'],
                'ratio': {
                    'polandDraught': el['count'] / polandDraughtConst,
                    'polandNormal': el['count'] / polandNormalConst,
                    'europe': el['count'] / europeConst
                }
            })
            resp['total'] += el['count']
        return JsonResponse(resp)

    return HttpResponseBadRequest()

