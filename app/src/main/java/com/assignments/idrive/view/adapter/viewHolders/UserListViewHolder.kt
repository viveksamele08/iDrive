package com.assignments.idrive.view.adapter.viewHolders
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.assignments.idrive.BR
import com.assignments.idrive.model.pintrest.UserObject
import com.assignments.idrive.viewmodel.UserListViewModel
import com.assignments.imageloader.ImageLoader
import kotlinx.android.synthetic.main.user_list_item_view.view.*
 import org.jetbrains.anko.sdk27.coroutines.onClick


class UserListViewHolder constructor(private val dataBinding: ViewDataBinding, private val videoListViewModel: UserListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    fun setup(userObject: UserObject) {
       dataBinding.setVariable(BR.itemData, userObject)
       dataBinding.executePendingBindings()


       ImageLoader.with(itemView.context).load(avatarImage, userObject.user.profileImage.large)

        itemView.onClick {
          //  val bundle = bundleOf("videoID" to userObject.id)
         //   itemView.findNavController().navigate(R.id.youtubeActivity, bundle)
       }
    }
}