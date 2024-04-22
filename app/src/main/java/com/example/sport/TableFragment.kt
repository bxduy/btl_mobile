package com.example.sport

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sport.model.Team
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TableFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TableFragment : Fragment(){
    companion object {
        const val ARG_TEAM = "teamInfor"

        fun newInstance(team: Team): TableFragment {
            val fragment = TableFragment()
            val args = Bundle()
            args.putSerializable(ARG_TEAM, team)
            fragment.arguments = args
            return fragment
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val team: Team? = arguments?.getSerializable(ARG_TEAM) as? Team
        val view = inflater.inflate(R.layout.fragment_table, container, false)
        val txtPlayed = view.findViewById<TextView>(R.id.txt_played)
        val txtWin = view.findViewById<TextView>(R.id.txt_win)
        val txtDraw = view.findViewById<TextView>(R.id.txt_draw)
        val txtLose = view.findViewById<TextView>(R.id.txt_lose)
        if (team != null) {
            val win = team.win
            val draw = team.draw
            val lose = team.lose
            txtPlayed.setText((win + draw + lose).toString())
            txtWin.setText(win.toString())
            txtDraw.setText(draw.toString())
            txtLose.setText(lose.toString())
        }
        return view
    }
}