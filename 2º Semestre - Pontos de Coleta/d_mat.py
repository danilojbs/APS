from math import sin, cos, sqrt, atan2, radians
from locais import loc1, loc2, loc3, loc4, loc5

def distancia (latA,lonA,Mat):

    if loc1[Mat] == True:
        lat2 = radians(loc1['lat'])
        lon2 = radians(loc1['lon'])

        lat1 = radians(latA)
        lon1 = radians(lonA)

        dlat = lat2 - lat1
        dlon = lon2 - lon1

        a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
        c = 2 * atan2(sqrt(a), sqrt(1 - a))

        R = 6371.0
        distancia_loc1 = R * c
    else:
        distancia_loc1 = 99999999

    if loc2[Mat] == True:
        lat2 = radians(loc2['lat'])
        lon2 = radians(loc2['lon'])

        lat1 = radians(latA)
        lon1 = radians(lonA)

        dlat = lat2 - lat1
        dlon = lon2 - lon1

        a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
        c = 2 * atan2(sqrt(a), sqrt(1 - a))

        R = 6371.0
        distancia_loc2 = R * c
    else:
        distancia_loc2 = 99999999

    if loc3[Mat] == True:
        lat2 = radians(loc3['lat'])
        lon2 = radians(loc3['lon'])

        lat1 = radians(latA)
        lon1 = radians(lonA)

        dlat = lat2 - lat1
        dlon = lon2 - lon1

        a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
        c = 2 * atan2(sqrt(a), sqrt(1 - a))

        R = 6371.0
        distancia_loc3 = R * c
    else:
        distancia_loc3 = 99999999


    if loc4[Mat] == True:
        lat2 = radians(loc4['lat'])
        lon2 = radians(loc4['lon'])

        lat1 = radians(latA)
        lon1 = radians(lonA)

        dlat = lat2 - lat1
        dlon = lon2 - lon1

        a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
        c = 2 * atan2(sqrt(a), sqrt(1 - a))

        R = 6371.0
        distancia_loc4 = R * c
    else:
        distancia_loc4 = 99999999

    if loc5[Mat] == True:
        lat2 = radians(loc5['lat'])
        lon2 = radians(loc5['lon'])

        lat1 = radians(latA)
        lon1 = radians(lonA)

        dlat = lat2 - lat1
        dlon = lon2 - lon1

        a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
        c = 2 * atan2(sqrt(a), sqrt(1 - a))

        R = 6371.0
        distancia_loc5 = R * c
    else:
        distancia_loc5 = 99999999

    if distancia_loc1 < distancia_loc2 and distancia_loc1 < distancia_loc3 and distancia_loc1 < distancia_loc4 and distancia_loc1 < distancia_loc5:
        print ('\nNome:',loc1['nome'])
        print ('Endereço:',loc1['endereço'])
        print ("Distancia: {:5.2f}".format(distancia_loc1) + " KM\n")
    
    if distancia_loc2 < distancia_loc1 and distancia_loc2 < distancia_loc3 and distancia_loc2 < distancia_loc4 and distancia_loc2 < distancia_loc5:
        print ('\nNome:',loc2['nome'])
        print ('Endereço:',loc2['endereço'])
        print ("Distancia: {:5.2f}".format(distancia_loc2) + " KM\n")

    if distancia_loc3 < distancia_loc1 and distancia_loc3 < distancia_loc2 and distancia_loc3 < distancia_loc4 and distancia_loc3 < distancia_loc5:
        print ('\nNome:',loc3['nome'])
        print ('Endereço:',loc3['endereço'])
        print ("Distancia: {:5.2f}".format(distancia_loc3) + " KM\n")

    if distancia_loc4 < distancia_loc1 and distancia_loc4 < distancia_loc2 and distancia_loc4 < distancia_loc3 and distancia_loc4 < distancia_loc5:
        print ('\nNome:',loc4['nome'])
        print ('Endereço:',loc4['endereço'])
        print ("Distancia: {:5.2f}".format(distancia_loc4) + " KM\n")
    
    if distancia_loc5 < distancia_loc1 and distancia_loc5 < distancia_loc2 and distancia_loc5 < distancia_loc3 and distancia_loc5 < distancia_loc4:
        print ('\nNome:',loc5['nome'])
        print ('Endereço:',loc5['endereço'])
        print ("Distancia: {:5.2f}".format(distancia_loc5) + " KM\n")