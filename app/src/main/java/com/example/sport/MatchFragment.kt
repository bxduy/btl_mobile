package com.example.sport

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sport.adapter.MatchAdapter
import com.example.sport.model.Match
import com.example.sport.model.Team
import com.example.sport.viewmodel.FavoriteViewModel
import kotlinx.android.synthetic.main.fragment_match.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MatchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MatchFragment : Fragment(){
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    companion object {
        const val ARG_TEAM = "teamInfor"

        fun newInstance(team: Team): MatchFragment {
            val fragment = MatchFragment()
            val args = Bundle()
            args.putSerializable(ARG_TEAM, team)
            fragment.arguments = args
            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]

        initControl()
    }

    private fun initControl() {
        val adapter: MatchAdapter = MatchAdapter(requireContext(), onClickItem)
        rv_match.setHasFixedSize(true)
        rv_match.layoutManager = LinearLayoutManager(requireContext())
        rv_match.adapter = adapter
        val team: Team? = arguments?.getSerializable(MatchFragment.ARG_TEAM) as? Team

        if (team != null) {
            favoriteViewModel.getMatchById(team.id).observe(viewLifecycleOwner, Observer {
                adapter.setMatchs(it)
            })
        }
    }

    private val onClickItem: (Match) -> Unit = { match ->
        val intent = Intent(requireActivity(), FavoriteDetail::class.java)
        val team: Team? = arguments?.getSerializable(MatchFragment.ARG_TEAM) as? Team
        intent.putExtra("team", team)
        startActivity(intent)
    }
}