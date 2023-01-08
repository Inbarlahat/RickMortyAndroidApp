//package com.example.rickmortyv3.ui.filter_characters
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Checkable
//import androidx.fragment.app.viewModels
//import androidx.navigation.fragment.findNavController
//import com.example.rickmortyv3.R
//import com.example.rickmortyv3.databinding.FragmentFilterCharactersBinding
//import com.example.rickmortyv3.ui.all_characters.AllCharactersViewModel
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//import dagger.hilt.android.AndroidEntryPoint
//import android.widget.RadioButton
//import android.widget.RadioGroup
//import com.google.android.material.chip.Chip
//import com.google.android.material.chip.ChipGroup
//
//
//@AndroidEntryPoint
//class FilterCharactersFragment : BottomSheetDialogFragment() {
//
//    private val viewModel: AllCharactersViewModel by viewModels()
//    private var _binding: FragmentFilterCharactersBinding? = null
//
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentFilterCharactersBinding.inflate(inflater,container,false);
//
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        viewModel.filterValue.observe(viewLifecycleOwner) {
////            binding.chipgroupStatus.setChipChecked(it[0])
////            binding.radiogroupGender.setButtonChecked(it[1])
//////        }
////
////        binding.btnMakeFilter.setOnClickListener {
////            if(binding.chipgroupStatus.getTextChipChecked().isNotEmpty() && binding.radiogroupGender.getTextButtonChecked().isNotEmpty()) {
////                viewModel.getByStatusAndGender(binding.chipgroupStatus.getTextChipChecked(), binding.radiogroupGender.getTextButtonChecked(), 1)
////            }else{
////                if(binding.chipgroupStatus.getTextChipChecked().isNotEmpty()){
////                    viewModel.getByStatus(binding.chipgroupStatus.getTextChipChecked(), 1)
////                }else{
////                    viewModel.getByGender(binding.radiogroupGender.getTextButtonChecked(), 1)
////                }
////            }
////
////            viewModel.filterValue.value = arrayOf(binding.chipgroupStatus.checkedChipId, binding.radiogroupGender.checkedRadioButtonId)
////
////            findNavController().popBackStack(R.id.allCharactersFragment, false)
////        }
////    }
////
////    fun setChecked(viewId: Int, checked: Boolean) {
////        (findView<View>(viewId) as Checkable).isChecked = checked
////    }
//
//fun ChipGroup.getTextChipChecked(): String{
//    val selectedId: Int = this.checkedChipId
//    return if(selectedId > -1) findViewById<Chip>(selectedId).text.toString() else " "
//}
//
//fun ChipGroup.setChipChecked(selectedId: Int){
//    if(selectedId > 0) this.findViewById<Chip>(selectedId).isChecked = true
//}
//
//    fun RadioGroup.getTextButtonChecked(): String {
//        val selectedId: Int = this.checkedRadioButtonId
//        return if(selectedId > -1) findViewById<RadioButton>(selectedId).text.toString() else " "
//    }
//
//    fun RadioGroup.setButtonChecked(selectedId: Int) {
//        if(selectedId > 0) findViewById<RadioButton>(selectedId).isChecked = true
//    }

//
////}
//        }}}