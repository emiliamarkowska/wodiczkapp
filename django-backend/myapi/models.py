from django.db import models

# Create your models here.

class UsageManager(models.Manager):
    def create_usage(self):
        usage = self.create()
        return usage

class Usage(models.Model):
    datetime = models.DateTimeField(auto_now_add=True)

    objects = UsageManager()

    def __str__(self):
        return str(self.datetime)