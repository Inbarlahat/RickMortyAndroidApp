package com.example.rickmortyv3.ui.create_character

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickmortyv3.data.models.CharacterManger
import com.example.rickmortyv3.data.models.SingleCharacter
import com.example.rickmortyv3.R
import com.example.rickmortyv3.data.models.CreatedCharacter
import com.example.rickmortyv3.databinding.FragmentCreateNewCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

class CreateNewCharacterFragment : Fragment() {

    private val viewModel : CreatedCharacterViewModel by viewModels()

    private var _binding: FragmentCreateNewCharacterBinding? = null

    private val binding get() = _binding!!

    fun interface AddItemListener {
        fun onFinished(name: String,
                       status: String,
                       species: String,
                       type: String,
                       gender: String,
                       image: String) : Unit
    }
    private var listener : AddItemListener? = null

    private lateinit var photoUri : Uri

    fun setListener(listener: AddItemListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateNewCharacterBinding.inflate(inflater,container,false);

        binding.picButton.setOnClickListener {
            getContent.launch(arrayOf("image/*"))
        }

        binding.backHomeBtn.setOnClickListener{
            findNavController().navigate(
                R.id.action_createNewCharacterFragment_to_homeFragment)}

        binding.finishBtn.setOnClickListener {
            val validName = binding.itemNameEt.text
            val validStatus = binding.itemStatusEt.text
            val validSpecies = binding.itemSpeciesEt.text
            val validType = binding.itemTypeEt.text
            val validGender = binding.itemGenderEt.text

            if (validName.isNullOrEmpty() || validSpecies.isNullOrEmpty() || validType.isNullOrEmpty() || validGender.isNullOrEmpty() || validStatus.isNullOrEmpty())
            {
//                Toast.makeText(requireContext(), "Must fill all fields!", Toast.LENGTH_LONG).show()

                val builder = AlertDialog.Builder(context)
                builder.apply {
                    setTitle(getString(R.string.error))
                    .setMessage(getString(R.string.error_empty_fields_msg))
                    .setCancelable(true)
                    .setIcon(R.mipmap.rickandmortylogo_round)
                    .setPositiveButton(getString(R.string.continue_button)){p0, p1->}
//                    setTitle(getString(R.string.popupTitle))

                    val dialog = builder.create()
                    dialog.show()
                }
            }
            else {
                viewModel.addCreatedCharacter(
                    CreatedCharacter(
                        binding.itemNameEt.text.toString(),
                        binding.itemStatusEt.text.toString(),
                        binding.itemSpeciesEt.text.toString(),
                        binding.itemTypeEt.text.toString(),
                        binding.itemGenderEt.text.toString(),
                        photoUri.toString()
                    )
                )

                findNavController().navigate(R.id.action_createNewCharacterFragment_to_createdCharactersFragment)
            }
        }
        return binding.root
    }

    private val getContent = registerForActivityResult((ActivityResultContracts.OpenDocument()))
    { uri: Uri? ->
        uri?.let {
            activity?.contentResolver?.takePersistableUriPermission(it,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            binding.imageView.setImageURI(it)
            binding.finishBtn.visibility = View.VISIBLE
            photoUri = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}