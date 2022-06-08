package com.example.exploraholic.MapScreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.R
import com.example.exploraholic.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    lateinit var mapFragment : SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            Log.d("GoogleMap", "before isMyLocationEnabled")
//            googleMap.isMyLocationEnabled = true
            val location1 = LatLng(18.5204, 73.8567)
            mMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 5f))

            Log.d("GoogleMap", "before Mahabaleshwar")
            val location2 = LatLng(17.921721, 73.655602)
            mMap.addMarker(MarkerOptions().position(location2).title("Distance of Mahabaleshwar is 117 km"))

            Log.d("GoogleMap", "before TigerHill")
            val location3 = LatLng(18.74220901, 73.405119945)
            mMap.addMarker(MarkerOptions().position(location3).title("Distance of Tiger Hill is 79.02 km "))

            Log.d("GoogleMap", "before Rajgad")
            val location4 = LatLng(18.516726, 73.856255)
            mMap.addMarker(MarkerOptions().position(location4).title("Distance of Rajgad is 35 km"))

            Log.d("GoogleMap", "before Lohgad")
            val location5 = LatLng(18.694317, 73.487259)
            mMap.addMarker(MarkerOptions().position(location5).title("Distance of Lohgad is 65.3 km"))

            Log.d("GoogleMap", "before Khadakwasla")
            val location6 = LatLng(18.50305, 73.90075)
            mMap.addMarker(MarkerOptions().position(location3).title("Distance of Khadakwasla is 13.6 km"))

            Log.d("GoogleMap", "before Mulashi")
            val location7 = LatLng(18.505007, 73.518105)
            mMap.addMarker(MarkerOptions().position(location7).title("Distance of Mulashi is 44.7 km"))

            distanceInKm(lat1 = 18.5204, lon1 = 73.8567, lat2 = 18.505007, lon2 = 73.518105 )
        } )
    }
    fun getDirectionURL(origin:LatLng,dest:LatLng) : String{
        return "https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}&destination=${dest.latitude},${dest.longitude}&sensor=false&mode=driving"
    }

    fun distanceInKm(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta))
        dist = Math.acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344
        return dist
    }

    private fun deg2rad(deg: Double): Double {
        return deg * Math.PI / 180.0
    }

    private fun rad2deg(rad: Double): Double {
        return rad * 180.0 / Math.PI
    }

//    inner class GetDirection(val url : String) : AsyncTask<Void, Void, List<List<LatLng>>>() {
//        override fun doInBackground(vararg params: Void?): List<List<LatLng>> {
//            val client = OkHttpClient()
//            val request = Request.Builder().url(url).build()
//            val response = client.newCall(request).execute()
//            val data = response.body!!.string()
//            Log.d("GoogleMap","Data: $data")
//            val result = ArrayList<List<LatLng>>()
//            try {
//                    val respObj = Gson().fromJson(data,GoogleMapDTO::class.java)
//
//                    val path = ArrayList<LatLng>()
//
//                for (i in 0..(respObj.routes[0].legs[0].steps.size-1)){
//                        val startLatLng = LatLng(respObj.routes[0].legs[0].steps[i].start_location.lat.toDouble(),
//                            respObj.routes[0].legs[0].steps[i].start_location.lng.toDouble())
//                    path.add(startLatLng)
//                    val endLatLng = LatLng(respObj.routes[0].legs[0].steps[i].end_location.lat.toDouble(),
//                        respObj.routes[0].legs[0].steps[i].end_location.lng.toDouble())
//                    path.add(endLatLng)
//                }
//                result.add(path)
//            }catch (e:Exception){
//                e.printStackTrace()
//            }
//            return result
//        }
//
//        override fun onPostExecute(result: List<List<LatLng>>) {
//            val lineoption = PolylineOptions()
//            for (i in result.indices){
//                lineoption.addAll(result[i])
//                lineoption.width(10f)
//                lineoption.color(android.graphics.Color.BLUE)
//                lineoption.geodesic(true)
//            }
//            mMap.addPolyline(lineoption)
//        }
//    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val Pune = LatLng(18.5204, 73.8567)
        mMap.addMarker(MarkerOptions().position(Pune).title("Marker in Pune"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Pune))

        val Mahabaleshwar = LatLng(17.921721, 73.655602)
        mMap.addMarker(MarkerOptions().position(Mahabaleshwar).title("Marker in Mahabaleshwar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mahabaleshwar))

        val TigerHill = LatLng(18.74220901, 73.405119945)
        mMap.addMarker(MarkerOptions().position(TigerHill).title("Marker in TigerHill"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TigerHill))

        val Rajgad = LatLng(18.516726, 73.856255)
        mMap.addMarker(MarkerOptions().position(Rajgad).title("Marker in Rajgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajgad))

        val Lohgad = LatLng(18.694317, 73.487259)
        mMap.addMarker(MarkerOptions().position(Lohgad).title("Marker in Lohgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lohgad))

        val Khadakwasla = LatLng(18.50305, 73.90075)
        mMap.addMarker(MarkerOptions().position(Khadakwasla).title("Marker in Khadakwasla"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Khadakwasla))

        val Mulashi = LatLng(18.505007, 73.518105)
        mMap.addMarker(MarkerOptions().position(Mulashi).title("Marker in Mulashi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mulashi))

//        val URL1 = getDirectionURL(Pune, Mahabaleshwar)
//        GetDirection(URL1).execute()

//        val results = FloatArray(1)
//        Location.distanceBetween(18.5204, 73.8567,
//            17.921721, 73.655602, results)
//        val distance = results[0]

//        val startPoint = Location("Pune")
//        startPoint.setLatitude(18.5204)
//        startPoint.setLongitude(73.8567)
//
//        val endPoint = Location("Tiger Hill")
//        endPoint.setLatitude(18.74220901)
//        endPoint.setLongitude(73.405119945)
//
//        val distance: Float = startPoint.distanceTo(endPoint)
//        Toast.makeText(this@MapsActivity, "Distance of Tiger hill is -> $distance", Toast.LENGTH_SHORT).show()

    }

//    private fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
//        val theta = lon1 - lon2
//        var dist = (Math.sin(deg2rad(lat1))
//                * Math.sin(deg2rad(lat2))
//                + (Math.cos(deg2rad(lat1))
//                * Math.cos(deg2rad(lat2))
//                * Math.cos(deg2rad(theta))))
//        dist = Math.acos(dist)
//        dist = rad2deg(dist)
//        dist = dist * 60 * 1.1515
//        return dist
//    }
//
//    private fun deg2rad(deg: Double): Double {
//        return deg * Math.PI / 180.0
//    }
//
//    private fun rad2deg(rad: Double): Double {
//        return rad * 180.0 / Math.PI
//    }


}