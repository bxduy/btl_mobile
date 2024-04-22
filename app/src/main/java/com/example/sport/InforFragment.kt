package com.example.sport

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sport.model.Team
import com.example.sport.viewmodel.FavoriteViewModel
import kotlinx.android.synthetic.main.fragment_infor.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InforFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InforFragment : Fragment(){
    companion object {
        const val ARG_TEAM = "teamInfor"

        fun newInstance(team: Team): InforFragment {
            val fragment = InforFragment()
            val args = Bundle()
            args.putSerializable(ARG_TEAM, team)
            fragment.arguments = args
            return fragment
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val team: Team? = arguments?.getSerializable(ARG_TEAM) as? Team
        val view = inflater.inflate(R.layout.fragment_infor, container, false)
        val txtInformation = view.findViewById<TextView>(R.id.txt_information)
        val txtLocation = view.findViewById<TextView>(R.id.txt_location)
        if (team != null) {
            txtInformation.setText(team.information)
            txtLocation.setText(team.country)
        }

        return view


    }

}
